import com.typesafe.sbt.SbtStartScript 
import sbt._
import sbt.Keys._
import io.escalante.sbt.EscalantePlugin._
import io.escalante.sbt.EscalantePlugin.EscalanteKeys._
escalanteSettings

name := "Lift 2.5 samples"

version := "0.0.1"

organization := "net.liftweb"

scalaVersion := "2.10.2"

resolvers ++= Seq("snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
                "releases"        at "http://oss.sonatype.org/content/repositories/releases"
                )

seq(SbtStartScript.startScriptForClassesSettings: _*)

// net.virtualvoid.sbt.graph.Plugin.graphSettings // for sbt dependency-graph plugin

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

liftWarName in liftWar := "escalante-lift-2.5-samples.war"

liftVersion in liftWar := Some("2.5")

libraryDependencies ++= {
  val liftVersion = "2.5"
  Seq(
    "net.liftweb"       %% "lift-webkit"        % liftVersion        % "provided",
    "net.liftweb"       %% "lift-wizard"        % liftVersion        % "provided",
    "net.liftweb"       %% "lift-mapper"        % liftVersion        % "provided",
    "net.liftmodules"   %% "textile_2.5"        % "1.3"      % "compile",
    "net.liftmodules"   %% "widgets_2.5"        % "1.3"      % "compile"
  )
}

