import akka.Done
import akka.stream.scaladsl.{Flow, Keep, Sink}
import org.scalatest.{FunSuite, Matchers}

import scala.concurrent.{Future, TimeoutException}

class AkkaStreamKata1Spec extends FunSuite with Matchers with GraphExec {


  test("define a Source that produces the BigIntegers from 1 to 10") {
    executeGraph(
      AkkaStreamKata1.sourceFirst10Ints
        .toMat(Sink.seq)(Keep.right)
    ) shouldBe (1 to 10).map(BigInt.apply)
  }

  test("define a Source that produces all BigIntegers starting from 1"){
    executeGraph(
      AkkaStreamKata1.sourceAllInts
        .via(Flow[BigInt].take(100))
        .toMat(Sink.seq)(Keep.right)
    ) shouldBe (1 to 100).map(BigInt.apply)

    assertThrows[TimeoutException](
      executeGraph(
        AkkaStreamKata1.sourceAllInts
          .toMat(Sink.takeLast(1))(Keep.right)
      )
    )
  }

  test("define a Flow that stringifies the input BigInteger"){
    executeGraph(
      AkkaStreamKata1.sourceFirst10Ints
        .via(AkkaStreamKata1.flowStringifyInteger)
        .toMat(Sink.seq)(Keep.right)
    ) shouldBe (1 to 10).map(_.toString)
  }

  test("define a Flow that filters every non-prime number from the input"){
    executeGraph(
      AkkaStreamKata1.sourceFirst10Ints
        .via(AkkaStreamKata1.flowPrimeFilter)
        .toMat(Sink.seq)(Keep.right)
    ) shouldBe Seq(2, 3, 5, 7)
  }

  test("define a Flow that accepts all values smaller than a given threshold and stops after that threshold was exceeded"){
    executeGraph(
      AkkaStreamKata1.sourceAllInts
        .via(AkkaStreamKata1.flowTakeWhileSmaller(50))
        .toMat(Sink.seq)(Keep.right)
    ) shouldBe (1 to 49)
  }

  test("define a Sink that executes a given callback"){
    var sum: BigInt = 0
    val callback: BigInt => Unit = n => sum += n

    executeGraph(
      AkkaStreamKata1.sourceFirst10Ints
        .toMat(AkkaStreamKata1.sinkForEach(callback))(Keep.right)
    ) shouldBe Done

    sum shouldBe 10 * 11 / 2
  }

  test("compose your Source, Flow and Sink into Runnable Graph so that a given callback is called for every stringified prime up to a given threshold"){
    var counter = 0
    val callback: String => Unit = _ => counter += 1

    executeGraph(
      AkkaStreamKata1.graphPrimes(500, callback)
        .mapMaterializedValue(_ => Future.successful(Done))
    )

    Thread.sleep(1000)
    counter shouldBe 95
  }

}
