sealed trait MyList[A]
case class MyNil[A]() extends MyList[A]
case class MyConst[A](head: A, tail: MyList[A]) extends MyList[A]

object MyListIsFunctor extends Functor[MyList]{
  override def map[A, B](data: MyList[A])(mapper: A => B): MyList[B] =
    data match {
      case MyNil() => MyNil()
      case MyConst(head, tail) => MyConst(mapper(head), map(tail)(mapper))
    }
}

object MyListIsMonad extends Monad[MyList] {
  private def concat[A](a: MyList[A], b: MyList[A]): MyList[A] = a match {
    case MyNil() => b
    case MyConst(head, tail) => MyConst(head, concat(tail, b))
  }

  def pure[A](a: A): MyList[A] = MyConst(a, MyNil())

  def flatMap[A, B](fa: MyList[A])(f: A => MyList[B]): MyList[B] = fa match {
    case MyNil() => MyNil()
    case MyConst(head, tail) => concat(f(head), flatMap(tail)(f))
  }
}
