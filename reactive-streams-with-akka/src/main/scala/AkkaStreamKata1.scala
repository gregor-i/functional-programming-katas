import akka.stream.scaladsl._
import akka.{Done, NotUsed}

import scala.concurrent.Future

object AkkaStreamKata1 {
  def sourceFirst10Ints: Source[BigInt, NotUsed] = ???

  def sourceAllInts: Source[BigInt, NotUsed] = ???

  def flowStringifyInteger: Flow[BigInt, String, NotUsed] = ???

  def isPrime(n: BigInt):Boolean = ???

  def flowPrimeFilter: Flow[BigInt, BigInt, NotUsed] = ???

  def flowTakeWhileSmaller(n: BigInt): Flow[BigInt, BigInt, NotUsed] = ???

  def sinkForEach[A](callback: A => Unit): Sink[A, Future[Done]] = ???

  def graphPrimes(threshold: BigInt, callback: String => Unit): RunnableGraph[NotUsed] = ???
}
