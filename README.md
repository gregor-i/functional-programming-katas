# Functional Programming Katas

## Getting started

0) install [sbt](https://www.scala-sbt.org/download.html)
1) execute `sbt` in this project folder.
2) select the kata you want to do with `project $projectname`. For example `project simple-lists`.
3) execute the tests with `test`. You may execute `~test` for continues test executions.

If you are stuck, you may take a look into the `solution` branch.

## Kata 1 - Simple Lists

Take a look into the `SimpleListSpec.scala` file. Uncomment the specs and implement your solution.
=======
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

## Kata 5 - Functional Type Classes

The starting point is the `TypeClassesSpec.scala` file. Just uncomment the spec and get started.

The goal of the project is to use type classes to implement common functional programming abstractions.
You will learn about type classes, Functors and Monads.

After completing the `TypeClassesSpec`, enable the `LawSpec` to check your implementation against the laws of the type classes.
Test cases are generated by [discipline](https://github.com/typelevel/discipline). 

Quick start:
```sh
sbt "~functional-type-classes/test"
```

## Kata 6 - Simple dependency injection

The point of this Kata is to explore a functional datastructure, that may be readily used
for a very simple but versatile form of dependency injection.

Your starting point is the spec for said construct, namely `ReaderSpec` file.

Your goal is to use this spec as guide to implement the datastructure called `Reader`.


## Kata _ - Reactive Streams with akka-streams

The starting point is the `AkkaStreamKata1Spec.scala` file. Just uncomment the spec and get started.

The goal of the project is to familiarize yourself with `Sinks`, `Sources` and `Flows` to learn the basis of akka streams.

Quick start:
```sh
sbt "~reactive-streams-with-akka/test"
```
