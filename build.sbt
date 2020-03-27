name := "IDriver"
version := "0.0.1"

scalaVersion := "2.13.1"

crossPaths := false

scalacOptions ++= Seq("-encoding", "UTF-8")

autoScalaLibrary := false

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % scalaVersion.value,
)

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8")

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.13" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test,
)
