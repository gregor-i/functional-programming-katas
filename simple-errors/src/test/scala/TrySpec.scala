import org.scalatest.{Matchers, WordSpec}

class TrySpec extends WordSpec with Matchers {


  "Try" should {

    val error = new Exception("Nope")

    "create successful results" in {
//      success(1) match {
//        case success: Success[Int] => success.result shouldBe 1
//        case _ => fail("should have created a successful computation")
//      }
    }

    "create failed results" in {
//      failure(error) match {
//        case failed: Failure[_] => failed.error shouldBe error
//        case _ => fail("should have created a failed computation")
//      }
    }

    "capture erroneous computation" in {
//      val attempt1 = attempt[Int] { () => 1 + 1 }
//      val attempt2 = attempt[Int] { () => throw error }
//
//      attempt1 shouldBe success(2)
//      attempt2 shouldBe failure(error)
    }

    "allow transformations when successful" in {
//      attempt[Int](() => 1 + 1).map(_ + 1) shouldBe success(3)
    }

    "disallow further transformations upon failure" in {
//      attempt[Int](() => 1 + 1).
//        map[Int] (_ => throw error).
//        map(_ + 1) shouldBe failure(error)
    }

    "allow continuations when successful" in {
//      val computation = attempt[String](() => "1").
//        flatMap[Int] { s => attempt[Int](() => s.toInt) }.
//        flatMap[Int] { n => attempt[Int](() => n + 1) }
//
//      computation shouldBe success(2)
    }

    "disallow further continuations upon failure" in {
//      val computation =
//        attempt[String](() => "true").
//          flatMap[Int] { _ => throw error }.
//          flatMap[Int] { n => attempt[Int](() => n + 1) }
//
//      computation shouldBe failure(error)
    }
  }
}
