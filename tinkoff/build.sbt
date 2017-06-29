name := "tinkoff"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.0" % "test",
  "org.pegdown"    %  "pegdown"     % "1.6.0"  % "test",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "net.databinder.dispatch" %% "dispatch-core" % "0.13.0" % "test",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % "test",
  "org.slf4j" % "slf4j-simple" % "1.7.25" % "test"
)

// log to stdout and html: target/test-reports/index.html
testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-o"),
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
)

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xfatal-warnings", // Fail the compilation if there are any warnings.
  "-Xlint", // Enable recommended additional warnings.
  "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver.
  "-Ywarn-dead-code", // Warn when dead code is identified.
  "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
  "-Ywarn-nullary-override", // Warn when non-nullary overrides nullary, e.g. def foo() over def foo.
  "-Ywarn-numeric-widen" // Warn when numerics are widened.
)