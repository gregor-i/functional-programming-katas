//import org.scalacheck.Prop._
//import org.scalacheck.{Arbitrary, Cogen, Prop}
//import org.scalatest.{Assertion, Matchers}
//import org.typelevel.discipline.Laws
//
//trait MonadLaws[F[_]] extends Laws with FunctorLaws[F] {
//  def F: Monad[F]
//
//  def monadLeftIdentity[A, B](a: A, f: A => F[B]): Prop =
//    F.flatMap(F.pure(a))(f) ?= f(a)
//
//  def monadRightIdentity[A](fa: F[A]): Prop =
//    F.flatMap(fa)(F.pure) ?= fa
//
//  def flatMapAssociativity[A, B, C](fa: F[A], f: A => F[B], g: B => F[C]): Prop =
//    F.flatMap(F.flatMap(fa)(f))(g) ?= F.flatMap(fa)(a => F.flatMap(f(a))(g))
//
//  def ruleSet[A: Arbitrary, B: Arbitrary, C: Arbitrary](implicit
//                                                        ArbFA: Arbitrary[F[A]],
//                                                        ArbFB: Arbitrary[F[B]],
//                                                        ArbFC: Arbitrary[F[C]],
//                                                        CogenA: Cogen[A],
//                                                        CogenB: Cogen[B],
//                                                        CogenC: Cogen[C]
//                                                       ): RuleSet = {
//    new DefaultRuleSet(
//      name = "functor",
//      parent = None,
//      "monad left identity" -> forAll(monadLeftIdentity[A, B] _),
//      "covariant composition" -> forAll(monadRightIdentity[A] _),
//      "flatMap associativity" -> forAll(flatMapAssociativity[A, B, C] _))
//  }
//}
//
//object MonadLaws {
//  def apply[F[_]](monad: Monad[F]): MonadLaws[F] =
//    new MonadLaws[F] {
//      def F: Monad[F] = monad
//    }
//}
