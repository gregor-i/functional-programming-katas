import akka.stream.scaladsl._
import akka.{Done, NotUsed}

import scala.concurrent.Future

object AkkaStreamKata1 {
  def sourceFirst10Ints: Source[BigInt, NotUsed] = Source.apply(1 to 10).map(BigInt.apply)

  def sourceAllInts: Source[BigInt, NotUsed] = Source.apply(Stream.iterate(BigInt(1))(_ + 1))

  def flowStringifyInteger: Flow[BigInt, String, NotUsed] = Flow[BigInt].map(_.toString)

  def isPrime(n: BigInt):Boolean = (n > 1) && (BigInt(2) until n).forall(n % _ != 0)

  def flowPrimeFilter: Flow[BigInt, BigInt, NotUsed] = Flow[BigInt].filter(isPrime)

  def flowTakeWhileSmaller(n: BigInt): Flow[BigInt, BigInt, NotUsed] = Flow[BigInt].takeWhile(_ < n)

  def sinkForEach[A](callback: A => Unit): Sink[A, Future[Done]] = Sink.foreach(callback)

  def graphPrimes(threshold: BigInt, callback: String => Unit): RunnableGraph[NotUsed] =
    sourceAllInts
    .via(flowPrimeFilter)
    .via(flowTakeWhileSmaller(threshold))
    .via(flowStringifyInteger)
    .to(sinkForEach(callback))
}
