import sbt._

object Dependencies {

  object Version {
    val akka = "2.4.1"
  }

  lazy val akka_guice = common  ++ injector

  val common = Seq(
    "ch.qos.logback" % "logback-classic" % "1.1.3",
    "com.typesafe.akka" %% "akka-actor" % Version.akka,
    "com.typesafe.akka" %% "akka-cluster" % Version.akka,
    "com.typesafe.akka" %% "akka-slf4j" % Version.akka
  )

  val injector = Seq(
    "net.codingwell" %% "scala-guice" % "4.0.1"
  )
}
