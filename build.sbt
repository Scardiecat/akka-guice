import NativePackagerHelper._
import sbt.Keys._


val commonSettings = Seq(
  organization := "org.scardiecat",
  version := "0.0.2",
  scalaVersion := "2.11.7",
  scalacOptions ++= Seq("-unchecked"
    , "-deprecation"
    , "-feature"
    , "-language:existentials"
    , "-language:higherKinds"),

  // build info
  buildInfoPackage := "meta",
  buildInfoOptions += BuildInfoOption.ToJson,
  buildInfoOptions += BuildInfoOption.BuildTime,
  buildInfoKeys := Seq[BuildInfoKey](
    name, version, scalaVersion
  ),
  publishMavenStyle := true,
  bintrayReleaseOnPublish in ThisBuild := false,
  bintrayPackageLabels := Seq("styx", "scala", "di"),
  licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
)

lazy val root = (project in file("."))
  .enablePlugins(BuildInfoPlugin, JavaAppPackaging)
  .settings(
    name := """styx-akka-guice""",
    publishMavenStyle := true,
    libraryDependencies ++= Dependencies.akka_guice,
    commonSettings
  )
