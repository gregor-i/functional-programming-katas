//import org.scalacheck.Prop._
//import org.scalacheck.{Arbitrary, Cogen, Prop}
//import org.typelevel.discipline.Laws
//
//// see: https://en.wikibooks.org/wiki/Haskell/The_Functor_class#The_functor_laws
//trait FunctorLaws[F[_]] extends Laws {
//  def F: Functor[F]
//
//  def covariantIdentity[A](fa: F[A]): Prop =
//    F.map(fa)(identity) ?= fa
//
//  def covariantComposition[A, B, C](fa: F[A], f: A => B, g: B => C): Prop =
//    F.map(F.map(fa)(f))(g) ?= F.map(fa)(f andThen g)
//
//  def ruleSet[A: Arbitrary, B: Arbitrary, C: Arbitrary](implicit
//                                                        ArbFA: Arbitrary[F[A]],
//                                                        CogenA: Cogen[A],
//                                                        CogenB: Cogen[B],
//                                                        CogenC: Cogen[C]
//                                                       ): RuleSet = {
//    new DefaultRuleSet(
//      name = "functor",
//      parent = None,
//      "covariant identity" -> forAll(covariantIdentity[A] _),
//      "covariant composition" -> forAll(covariantComposition[A, B, C] _))
//  }
//}
//
//object FunctorLaws {
//  def apply[F[_]](functor: Functor[F]): FunctorLaws[F] =
//    new FunctorLaws[F] {
//      def F: Functor[F] = functor
//    }
//}
