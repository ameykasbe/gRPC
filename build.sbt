name := "gRPC-final"

version := "0.1"

scalaVersion := "3.1.0"

name := "gRPC-New"

version := "0.1"

scalaVersion := "3.1.0"

// Minimum required for protobuf compilation
Compile / PB.targets := Seq(
  scalapb.gen() -> (Compile / sourceManaged).value / "scalapb"
)
// Protoc file
PB.protocExecutable := file("/opt/homebrew/Cellar/protobuf/3.17.3/bin/protoc")

// Library dependencies - scalapb
libraryDependencies ++= Seq(
  "io.grpc" % "grpc-netty" % scalapb.compiler.Version.grpcJavaVersion,
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf",
)



val typesafeConfigVersion = "1.4.1"

val scalacticVersion = "3.2.9"

val logbackVersion = "1.3.0-alpha10"
val sfl4sVersion = "2.0.0-alpha5"

// Typesafe config dependencies
libraryDependencies += "com.typesafe" % "config" % typesafeConfigVersion

// Scalatest dependencies
libraryDependencies += "org.scalactic" %% "scalactic" % scalacticVersion
libraryDependencies += "org.scalatest" %% "scalatest" % scalacticVersion % Test
libraryDependencies += "org.scalatest" %% "scalatest-featurespec" % scalacticVersion % Test

// Logback dependencies
libraryDependencies += "ch.qos.logback" % "logback-core" % logbackVersion
libraryDependencies += "ch.qos.logback" % "logback-classic" % logbackVersion
libraryDependencies += "org.slf4j" % "slf4j-api" % sfl4sVersion