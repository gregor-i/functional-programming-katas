import java.util.Optional
import org.scalatest.{Matchers, WordSpec}
import util.Tuple
import scala.collection.JavaConverters._
import scala.util.Random

class StreamSpec extends WordSpec with Matchers {

  "A Stream (data-structure)" should {

    "be immutable" in {
//      val stream = new SCons[Int](() => 1, () => new SNil[Int])
//
//      "stream.head = () => 2" shouldNot compile
//      "stream.tail = () => stream" shouldNot compile
    }

    "have public fields" in {
//      val nnil = new SNil[Int]
//      val stream = new SCons[Int](() => 1, () => nnil)
//
//      stream.head.get() shouldBe 1
//      stream.tail.get() shouldBe nnil
    }

    "be polymorphic" in {
//      val stream1 = new SCons[Int](() => 1, () => new SNil[Int])
//      val stream2 = new SCons[Boolean](() => true, () => new SNil[Boolean])
//
//      succeed
    }

    "have a function for constructing one" in {
//      val nrs = (0 until Random.nextInt(1000)).toList
//
//      toList(create(nrs:_*)).asScala.toList shouldBe nrs
    }

    "prepend lazily" in {
//      var parasite = 0
//      val nil: IStream[Int] = new SNil[Int]
//      val _ = prepend(() => { parasite = parasite + 1; 1 }, () => nil)
//      parasite shouldBe 0
    }

    "not overflow the stack" in {
//      def ones: IStream[Int] = prepend[Int](() => 1, () => ones)
//      val one = ones
//
//      succeed
    }

    "be forcibly transformed into lists" in {
//      var parasite = 0
//      val nil = new SNil[Integer]
//      val stream = prepend[Integer](() => {
//        parasite = parasite + 1
//        1
//      }, () => prepend(() => {
//        parasite = parasite + 1
//        2
//      }, () => prepend(() => {
//        parasite = parasite + 1
//        3
//      }, () => {
//        parasite = parasite + 1
//        nil
//      })))
//
//      parasite shouldBe 0
//      toList(stream).asScala.toList shouldBe List(1, 2, 3)
//      parasite shouldBe 4
    }

    "map lazily" in {
//      var parasite = 0
//      val stream = create(1, 2, 3)
//
//      val newStream = map[Int, Int](stream, x => {
//        parasite = parasite + 1
//        x + 1
//      })
//
//      parasite shouldBe 0
//      toList(newStream).asScala.toList shouldBe List(2, 3, 4)
//      parasite shouldBe 3
    }

    "filter lazily" in {
//      var parasite = 0
//      val stream = create(1, 2, 3, 4)
//
//      val newStream = filter[Int](stream, x => {
//        parasite = parasite + 1
//        x < 3
//      })
//
//      parasite shouldBe 1
//      toList(newStream).asScala.toList shouldBe List(1, 2)
//      parasite shouldBe 4
    }

    "take values lazily" in {
//      var parasite = 0
//      val stream = prepend[Int](() => {
//        parasite = parasite + 1
//        1
//      }, () => prepend(() => {
//        parasite = parasite + 1
//        2
//      }, () => prepend(() => {
//        parasite = parasite + 1
//        3
//      }, () => {
//        parasite = parasite + 1
//        new SNil[Int]
//      })))
//
//      parasite shouldBe 0
//      toList(take(stream, 2)).asScala.toList shouldBe List(1, 2)
//      parasite shouldBe 2
    }

    "evaluate lazily over all operations" in {
//      var parasite = 0
//      val stream = prepend[Int](() => {
//        parasite = parasite + 1
//        1
//      }, () => prepend(() => {
//        parasite = parasite + 1
//        2
//      }, () => prepend(() => {
//        parasite = parasite + 1
//        3
//      }, () => prepend(() => {
//        parasite = parasite + 1
//        4
//      },
//        () => {
//          parasite = parasite + 1
//          new SNil[Int]
//        }))))
//
//      val mapped = map[Int, Int](stream, x => {
//        parasite = parasite + 1
//        x + 1
//      })
//
//      val filtered = filter[Int](mapped, x => {
//        parasite = parasite + 1
//        x % 2 == 0
//      })
//
//      val newStream = take(filtered, 2)
//
//      parasite shouldBe 3
//      toList(newStream).asScala.toList shouldBe List(2, 4)
    }

    "zip itself with other streams" in {
//      val letters = create("A", "B", "C")
//      val numbers = create(1, 2, 3, 4)
//      val zipped = zip (letters, numbers)
//
//      toList(zipped).asScala.toList shouldBe List(Tuple.of("A", 1), Tuple.of("B", 2), Tuple.of("C", 3))
    }

    "implement `iterate` to create infinite things" in {
//      val naturalNumbers = iterate[Integer](0, x => Optional.of(x + 1))
//      val n = Random.nextInt(1000)
//
//      toList(take(naturalNumbers, n)).asScala.toList shouldBe (0 until n).toList
    }

  }
}
