name := "functional-programming-katas"
scalaVersion in ThisBuild := "2.12.6"

def scalaTest = libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

lazy val `simple-lists` = project.in(file("simple-lists"))
  .settings(
    name := "simple-lists",
    scalaTest
  )

lazy val `simple-streams` = project.in(file("simple-streams"))
  .settings(
    name := "simple-streams",
    scalaTest
  )

lazy val `simple-errors` = project.in(file("simple-errors"))
  .settings(
    name := "simple-errors",
    scalaTest
  )

lazy val `simple-generators` = project.in(file("simple-generators"))
  .settings(
    name := "simple-generators",
    scalaTest
  )

