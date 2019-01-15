import org.scalatest.{Matchers, WordSpec}
import reader.Reader._


class ReaderSpec extends WordSpec with Matchers {

  "A Reader" should {

    case class Dep(things: List[Int])

    val items = List(1, 2, 3)
    val environment = Dep(items)

    "allow creation and running of dependent computations" in {
//      val function = reader { (dep: Dep) => dep.things.sum }
//
//      function.run(environment) shouldBe items.sum
    }

    "ask for an environment" in {
//      val asked = ask[Dep]
//
//      asked.run(environment) shouldBe environment
    }


    "have a Functor" in {
//      val function = ask[Dep].map(_.things.sum)
//
//      function.run(environment) shouldBe items.sum
    }


    "have a Monad" in {
//        val computation = ask[Dep].flatMap { env1 =>
//          ask[Dep].map { env2 =>
//            (env1.things.sum, env2.things.tail.sum)
//          }
//        }
//
//      computation.run(environment) shouldBe (items.sum, items.tail.sum)
    }

    "have a contravariant Functor" in {
//      val computation1 = ask[Dep].map (_.things.sum)
//      val computation2 = ask[(Dep, Int)].map { case (dep, i) => dep.things.sum + i }
//
//      val composed = computation1.contramap[(Dep, Int)] { env => env._1 } .flatMap { result1 =>
//        computation2.map { result2 =>
//          (result1, result2)
//        }
//      }
//
//      composed.run((environment, 1)) shouldBe (items.sum, items.sum + 1)
    }

    "locally alter the environment" in {
//      val functionMore = ask[(Dep, Int)]
//      val functionLess = ask[Dep]
//
//      val computation = for {
//        less <- functionLess.local[(Dep, Int)] { wholeEnv => wholeEnv._1 }
//        more <- functionMore
//      } yield (less.things.sum, more._1.things.sum + more._2)
//
//      computation.run((environment, 1)) shouldBe (items.sum, items.sum + 1)
    }
  }
}
