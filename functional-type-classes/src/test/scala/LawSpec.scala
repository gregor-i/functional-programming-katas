import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.FunSuite
import org.typelevel.discipline.scalatest.Discipline

class LawSpec extends FunSuite with Discipline {
//  checkAll("MyList is Functor", FunctorLaws(MyListIsFunctor).ruleSet[Int, String, Double])
//  checkAll("MyOption is Functor", FunctorLaws(MyOptionIsFunctor).ruleSet[Int, String, Double])
//
//  checkAll("MyOption is Monad", MonadLaws(MyOptionIsMonad).ruleSet[Int, String, Double])
//  checkAll("MyList is Monad", MonadLaws(MyListIsMonad).ruleSet[Int, String, Double])
//
//
//  def optionToMyOption[A](o: Option[A]): MyOption[A] = o.fold[MyOption[A]](MyNone())(MySome.apply)
//
//  implicit def genMyOption[A: Arbitrary]: Arbitrary[MyOption[A]] = Arbitrary(implicitly[Arbitrary[Option[A]]].arbitrary.map(optionToMyOption))
//
//  def listToMyList[A](list: List[A]): MyList[A] = list match {
//    case Nil => MyNil()
//    case head :: tail => MyConst(head, listToMyList(tail))
//  }
//
//  implicit def genMyList[A](implicit arbA: Arbitrary[A]): Arbitrary[MyList[A]] = Arbitrary(
//    for {
//      s <- Gen.choose(0, 30)
//      l <- Gen.listOfN(s, arbA.arbitrary)
//    } yield listToMyList(l)
//  )
}
