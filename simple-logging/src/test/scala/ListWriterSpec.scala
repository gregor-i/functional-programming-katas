import org.scalatest.{Matchers, WordSpec}
import writer.ListWriter
import writer.ListWriter._

class ListWriterSpec extends WordSpec with Matchers {

  "A ListWriter" should {

    "allow creation with some simple output value and result" in {
//      val args = (0 to 1000).map { _.toString }
//      val w1 = writer(1)
//      val w2 = writer (1, args: _*)
//
//      w1.value shouldBe 1
//      w1.output shouldBe List()
//
//      w2.value shouldBe 1
//      w2.output shouldBe args.toList
    }

    "write output" in {
//      val w = writer(1, "1")
//
//      tell("2").output shouldBe List("2")
//      tell("2").value shouldBe ()
//
//      w.tell("2").output shouldBe List("1", "2")
//      w.tell("2").value shouldBe 1
    }

    "listen to output" in {
//      val args = (0 to 1000).map { _.toString }
//      val w1 = writer(1, "1")
//      val w2 = writer(1, args:_*)
//
//      w1.listen.value shouldBe (1, List("1"))
//      w2.listen.value shouldBe (1, args.toList)
    }

    "change output" in {
//      val f = (xs: List[String]) => "hello" :: xs
//      val w = writer(1, "world")
//
//      w.mapOutput(f).output shouldBe List("hello", "world")
//      w.value shouldBe 1
    }

    "have a Functor" in {
//      val w = writer(1, "1").map(_ + 1)
//
//      w.value shouldBe 2
//      w.output shouldBe List("1")
    }

    "have a Monad" in {
//      val w1 = writer(1, "1")
//      val w2 = writer(2, "2")
//
//      w1.flatMap { x => w2.map { y => x + y }}.value shouldBe 3
//      w1.flatMap { _ => w2 }.output shouldBe List("1", "2")
    }
  }
}
