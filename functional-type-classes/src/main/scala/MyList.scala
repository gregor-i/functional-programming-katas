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
