package gRPC.protobuf.LogAnalyzerProtobuf

object LogAnalyzerGrpc {
  val METHOD_ANALYZE: _root_.io.grpc.MethodDescriptor[gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogRequest, gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogResponse] =
    _root_.io.grpc.MethodDescriptor.newBuilder()
      .setType(_root_.io.grpc.MethodDescriptor.MethodType.UNARY)
      .setFullMethodName(_root_.io.grpc.MethodDescriptor.generateFullMethodName("gRPC.protobuf.LogAnalyzer", "Analyze"))
      .setSampledToLocalTracing(true)
      .setRequestMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogRequest])
      .setResponseMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogResponse])
      .setSchemaDescriptor(_root_.scalapb.grpc.ConcreteProtoMethodDescriptorSupplier.fromMethodDescriptor(gRPC.protobuf.LogAnalyzerProtobuf.LogAnalyzerProtobufProto.javaDescriptor.getServices().get(0).getMethods().get(0)))
      .build()
  
  val SERVICE: _root_.io.grpc.ServiceDescriptor =
    _root_.io.grpc.ServiceDescriptor.newBuilder("gRPC.protobuf.LogAnalyzer")
      .setSchemaDescriptor(new _root_.scalapb.grpc.ConcreteProtoFileDescriptorSupplier(gRPC.protobuf.LogAnalyzerProtobuf.LogAnalyzerProtobufProto.javaDescriptor))
      .addMethod(METHOD_ANALYZE)
      .build()
  
  trait LogAnalyzer extends _root_.scalapb.grpc.AbstractService {
    override def serviceCompanion = LogAnalyzer
    /** Analyzes log
      */
    def analyze(request: gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogRequest): scala.concurrent.Future[gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogResponse]
  }
  
  object LogAnalyzer extends _root_.scalapb.grpc.ServiceCompanion[LogAnalyzer] {
    implicit def serviceCompanion: _root_.scalapb.grpc.ServiceCompanion[LogAnalyzer] = this
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = gRPC.protobuf.LogAnalyzerProtobuf.LogAnalyzerProtobufProto.javaDescriptor.getServices().get(0)
    def scalaDescriptor: _root_.scalapb.descriptors.ServiceDescriptor = gRPC.protobuf.LogAnalyzerProtobuf.LogAnalyzerProtobufProto.scalaDescriptor.services(0)
    def bindService(serviceImpl: LogAnalyzer, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition =
      _root_.io.grpc.ServerServiceDefinition.builder(SERVICE)
      .addMethod(
        METHOD_ANALYZE,
        _root_.io.grpc.stub.ServerCalls.asyncUnaryCall(new _root_.io.grpc.stub.ServerCalls.UnaryMethod[gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogRequest, gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogResponse] {
          override def invoke(request: gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogRequest, observer: _root_.io.grpc.stub.StreamObserver[gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogResponse]): _root_.scala.Unit =
            serviceImpl.analyze(request).onComplete(scalapb.grpc.Grpc.completeObserver(observer))(
              executionContext)
        }))
      .build()
  }
  
  trait LogAnalyzerBlockingClient {
    def serviceCompanion = LogAnalyzer
    /** Analyzes log
      */
    def analyze(request: gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogRequest): gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogResponse
  }
  
  class LogAnalyzerBlockingStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[LogAnalyzerBlockingStub](channel, options) with LogAnalyzerBlockingClient {
    /** Analyzes log
      */
    override def analyze(request: gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogRequest): gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogResponse = {
      _root_.scalapb.grpc.ClientCalls.blockingUnaryCall(channel, METHOD_ANALYZE, options, request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): LogAnalyzerBlockingStub = new LogAnalyzerBlockingStub(channel, options)
  }
  
  class LogAnalyzerStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[LogAnalyzerStub](channel, options) with LogAnalyzer {
    /** Analyzes log
      */
    override def analyze(request: gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogRequest): scala.concurrent.Future[gRPC.protobuf.LogAnalyzerProtobuf.AnalyzeLogResponse] = {
      _root_.scalapb.grpc.ClientCalls.asyncUnaryCall(channel, METHOD_ANALYZE, options, request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): LogAnalyzerStub = new LogAnalyzerStub(channel, options)
  }
  
  def bindService(serviceImpl: LogAnalyzer, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition = LogAnalyzer.bindService(serviceImpl, executionContext)
  
  def blockingStub(channel: _root_.io.grpc.Channel): LogAnalyzerBlockingStub = new LogAnalyzerBlockingStub(channel)
  
  def stub(channel: _root_.io.grpc.Channel): LogAnalyzerStub = new LogAnalyzerStub(channel)
  
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = gRPC.protobuf.LogAnalyzerProtobuf.LogAnalyzerProtobufProto.javaDescriptor.getServices().get(0)
  
}