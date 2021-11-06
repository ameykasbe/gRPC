package gRpc

import io.grpc.{Server, ServerBuilder}
import gRPC.protobuf.LogAnalyzerProtobuf.{AnalyzeLogRequest, AnalyzeLogResponse, LogAnalyzerProtobufProto, LogAnalyzerGrpc}
import scala.concurrent.ExecutionContext
import org.slf4j.{LoggerFactory, Logger}

class LogAnalyzerServer(server: Server) {
  // Create logger
  val logger = LoggerFactory.getLogger(getClass)

  /*
    Stop serving requests and shutdown resources.
  */
  def serverStop() = {
    // Shutdown server
    server.shutdown()
  }

  /*
  Start serving requests.
  */
  def serverStart() = {
    // Start server
    server.start()

    logger.info(s"Server started. Listening on ${server.getPort}.")

    // Add a hook to shutdown the server. When JVM is shutdown, server gets shutdown.
    sys.addShutdownHook {
      // Added println statements instead of logger since the logger may get reset by its JVM shutdown hook.
      System.err.println("Shutting down gRPC server since JVM is shutting down")
      serverStop()
      System.err.println("Server shut down completed")
    }
    ()
  }

  /*
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  def waitUntilShutdown() = {
    server.awaitTermination()
  }
}

object LogAnalyzerServer extends App {

    /*
   Create a server listening on a port.
   */
    // Define port
    val port = 8980

    // Create service instance
    val grpcServiceInstance = new LogAnalyzerService(new AnalyzeLogResponse)
  logger.info("gRPC Service instance created")

    // Create a server instance using serverBuilder as a base
    val server = new LogAnalyzerServer(ServerBuilder.forPort(port).addService(
      LogAnalyzerGrpc.bindService(
        grpcServiceInstance,
        scala.concurrent.ExecutionContext.global
      )
    ).build()
    )

    // Start the server
    server.serverStart()

    // Server should be kept running until manual shutdown
    server.waitUntilShutdown()


}

