name := "functional-programming-katas"
scalaVersion in ThisBuild := "2.13.14"

lazy val `simple-lists` = project.in(file("simple-lists"))
  .settings(
    name := "simple-lists",
    scalaTest
  )

//lazy val `simple-streams` = project.in(file("simple-streams"))
//  .settings(
//    name := "simple-streams",
//    scalaTest
//  )
//
//lazy val `simple-errors` = project.in(file("simple-errors"))
//  .settings(
//    name := "simple-errors",
//    scalaTest
//  )
//
//lazy val `simple-generators` = project.in(file("simple-generators"))
//  .settings(
//    name := "simple-generators",
//    scalaTest
//  )
//
//lazy val `simple-dependency-injection` = project.in(file("simple-dependency-injection"))
//  .settings(
//    name := "simple-dependency-injection",
//    scalaTest
//  )
//
//lazy val `simple-logging` = project.in(file("simple-logging"))
//  .settings(
//    name := "simple-logging",
//    scalaTest
//  )
//
//
//lazy val `reactive-streams-with-akka` = project.in(file("reactive-streams-with-akka"))
//  .settings(
//    name := "reactive-streams-with-akka",
//    scalaTest,
//    akkaStreams
//  )
//
//lazy val `functional-type-classes` = project.in(file("functional-type-classes"))
//  .settings(
//    name := "functional-type-classes",
//    scalaTest,
//    discipline
//  )

def scalaTest = libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test
//def akkaStreams = libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.17"
//def discipline = libraryDependencies += "org.typelevel" %% "discipline" % "0.10.0" % Test
