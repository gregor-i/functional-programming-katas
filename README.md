# Functional Programming Katas

## Getting started

0) install [sbt](https://www.scala-sbt.org/download.html)
1) execute `sbt` in this project folder.
2) select the kata you want to do with `project $projectname`. For example `project simple-lists`.
3) execute the tests with `test`. You may execute `~test` for continues test executions.

If you are stuck, you may take a look into the `solution` branch.

## Kata 1 - Simple Lists

The starting point is the `SimpleListSpec.scala` file. Just uncomment the spec and get started.
 
The goal of the project is to implement a immutable List data structure.
You will learn about immutablity, function passing and recursion.

Feel free to implement your solution first in java and then in scala.

Quick start:
```sh
sbt ~simple-lists/test
```

## Kata 2 - Simple Streams

todo

## Kata 3 - Simple Errors

todo

## Kata 4 - Simple Generators

todo

## Kata 5 - Reactive Streams with akka-streams

The starting point is the `AkkaStreamKata1Spec.scala` file. Just uncomment the spec and get started.

The goal of the project is to familiarize yourself with `Sinks`, `Sources` and `Flows` to learn the basis of akka streams.

Quick start:
```sh
sbt "~reactive-streams-with-akka/test"
```
