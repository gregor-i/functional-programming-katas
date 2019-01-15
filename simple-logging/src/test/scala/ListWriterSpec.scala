import org.scalatest.{Matchers, WordSpec}

class ListWriterSpec extends WordSpec with Matchers {

  "A ListWriter" should {

    "allow creation with some simple output value and result" in {
      val args = (0 to 1000).map { _.toString }
      val w1 = writer(1)
      val w2 = writer (1, args: _*)

      w1.value shouldBe 1
      w1.output shouldBe List("1")

      w2.value shouldBe 1
      v2.output shouldBe args.toList
    }

    "write output" in {
      val w = writer(1, "1")

      tell("2").output shouldBe List("1")
      tell("2").value shouldBe ()

      w.tell("2").output shouldBe List("1", "2")
      w.tell("2").value shouldBe 1
    }

    "listen to output" in {
      val args = (0 to 1000).map { _.toString }
      val w1 = writer(1, "1")
      val w2 = writer(1, args:_*)

      w1.listen.result shouldBe (1, List("1"))
      w2.listen.result shouldBe (1, args.toList)
    }

    "change output" in {
      val f = (x: String) => "hello " + x
      val w = writer((1, f))

      w.pass.output shouldBe "hello world"
    }

    "have a Functor" in {
      val w = writer(1, "1").map(_ + 1)

      w.value.value shouldBe 2
      w.output shouldBe List("1")
    }

    "have a Monad" in {
      val w1 = writer(1, "1")
      val w2 = writer(2, "2")

      w1.flatMap { x => w2.map { y => x + y }}.output shouldBe 3
      w1.flatMap { _ => w2 }.output shouldBe List("1", "2")
    }
  }
}
