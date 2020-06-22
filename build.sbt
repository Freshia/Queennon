val ScalatraVersion = "2.7.0"

organization := "com.example"

name := "quennon"

version := "0.1.0"

scalaVersion := "2.12.3"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.28.v20200408" % "container",
  //"org.eclipse.jetty" % "jetty-webapp" % "9.4.8.v20171121" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "org.scalaj" % "scalaj-http_2.12" % "2.4.2",
  "com.lihaoyi" %% "upickle" % "0.7.1"
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)
