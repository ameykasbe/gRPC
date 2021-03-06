package gRpc
import gRPC.protobuf.LogAnalyzerProtobuf.{AnalyzeLogRequest, AnalyzeLogResponse, LogAnalyzerGrpc}
import scala.concurrent.Future
import scala.io.Source
import org.slf4j.{LoggerFactory, Logger}

class LogAnalyzerService(searchResponse: AnalyzeLogResponse) extends LogAnalyzerGrpc.LogAnalyzer {
  // Create logger
  val logger = LoggerFactory.getLogger(getClass)

  // Overriding analyze method from the LogAnalyzer trait of LogAnalyzerGrpc.scala generated by ScalaPB
  override def analyze(request: AnalyzeLogRequest): Future[AnalyzeLogResponse] = {
    // Parameters from the request
    val inputDate = request.inputDate
    val inputTime = request.inputTime
    val deltaTime = request.deltaTime
    val deltaTime = request.pattern
    logger.info("Parameters parsed from request")

    // GET request
    val response = scala.io.Source.fromURL(s"https://3ekrhlf0g0.execute-api.us-east-2.amazonaws.com/default/lambda_grpc?input_date=$inputDate&input_time=$inputTime&delta_time=$deltaTime&pattern=$pattern").mkString

    logger.info("Response generated")
    Future.successful(AnalyzeLogResponse(response))
  }
}

object LogAnalyzerService{

}

