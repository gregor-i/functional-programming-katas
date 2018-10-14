sealed trait MyOption[A]
case class MyNone[A]() extends MyOption[A]
case class MySome[A](value: A) extends MyOption[A]

object MyOptionIsFunctor extends Functor[MyOption]{
  override def map[A, B](data: MyOption[A])(mapper: A => B): MyOption[B] =
    data match {
      case MySome(d) => MySome(mapper(d))
      case MyNone() => MyNone()
    }
}

object MyOptionIsMonad extends Monad[MyOption]{
  override def pure[A](a: A): MyOption[A] = MySome(a)
  override def flatMap[A, B](fa: MyOption[A])(f: A => MyOption[B]): MyOption[B] = fa match {
    case MySome(a) => f(a)
    case MyNone() => MyNone()
  }
}
