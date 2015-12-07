import NativePackagerHelper._


val commonSettings = Seq(
  organization := "org.scardiecat",
  version := "0.0.1",
  scalaVersion := "2.11.7",

  // build info
  buildInfoPackage := "meta",
  buildInfoOptions += BuildInfoOption.ToJson,
  buildInfoOptions += BuildInfoOption.BuildTime,
  buildInfoKeys := Seq[BuildInfoKey](
    name, version, scalaVersion
  )
)

lazy val root = (project in file("."))
  .enablePlugins(BuildInfoPlugin, JavaAppPackaging)
  .settings(
    name := """styx-akka-guice""",
    publishMavenStyle := true,
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
    libraryDependencies ++= Dependencies.akka_guice,
    commonSettings
  )
