name := "functional-programming-katas"
scalaVersion in ThisBuild := "2.12.6"


def scalaTest = libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

lazy val `simple-lists` = project.in(file("simple-lists"))
  .settings(
    name := "simple-lists",
    scalaTest
  )
