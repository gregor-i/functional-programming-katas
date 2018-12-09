//sealed trait MyList[A] extends MyListOps[A]
//case class MyNil[A]() extends MyList[A]
//case class MyConst[A](head: A, tail: MyList[A]) extends MyList[A]
//
//trait MyListOps[A]{ _: MyList[A] =>
//  def length: Int = this match {
//    case MyNil() => 0
//    case MyConst(_, tail) => 1 + tail.length
//  }
//
//  def find(f: A => Boolean): Option[A] = this match {
//    case MyNil() => None
//    case MyConst(head, tail) if f(head) => Some(head)
//    case MyConst(head, tail) => tail.find(f)
//  }
//
//  def get(i: Int): Option[A] = this match {
//    case MyNil() => None
//    case MyConst(head, tail) if i == 0 => Some(head)
//    case MyConst(head, tail) => tail.get(i-1)
//  }
//
//  def prepend(a: A) = MyConst(a, this)
//
//  def append(a: A): MyList[A] = this match {
//    case MyNil() => MyConst(a, MyNil())
//    case MyConst(head, tail) => MyConst(head, tail.append(a))
//  }
//
//  def concat(other: MyList[A]): MyList[A] = this match {
//    case MyNil() => other
//    case MyConst(head, tail) => MyConst(head, tail ++ other)
//  }
//
//  def ++(other: MyList[A]): MyList[A] = concat(other)
//
//  def map[B](f: A => B): MyList[B] = this match{
//    case MyNil() => MyNil()
//    case MyConst(head, tail) => MyConst(f(head), tail.map(f))
//  }
//
//  def filter(f: A => Boolean): MyList[A] = this match {
//    case MyNil() => MyNil()
//    case MyConst(head, tail) if f(head) => MyConst(head, tail.filter(f))
//    case MyConst(head, tail) => tail.filter(f)
//  }
//
//  def foreach(f: A => Unit): Unit = this match {
//    case MyNil() => ()
//    case MyConst(head, tail) =>
//      f(head)
//      tail.foreach(f)
//  }
//
//  def flatMap[B](f: A => MyList[B]): MyList[B] = this match {
//    case MyNil() => MyNil()
//    case MyConst(head, tail) => f(head) ++ tail.flatMap(f)
//  }
//
//  def fold[B](b0: B, f: (A, B) => B): B = this match {
//    case MyNil() => b0
//    case MyConst(head, tail) => f(head, tail.fold(b0, f))
//  }
//
//  def join(seperator: String): String = this match {
//    case MyNil() => ""
//    case MyConst(head, tail @ MyConst(_, _)) =>
//      head.toString + seperator + tail.join(seperator)
//    case MyConst(head, MyNil()) => head.toString
//  }
//
//  def join(prefix: String, seperator: String, postfix: String): String =
//    prefix + this.join(seperator) + postfix
//
//  override def toString = join("MyList(", ", ", ")")
//}
//
//object MyList{
//  def construct[A](args: A*): MyList[A] = args.headOption match {
//    case None => MyNil()
//    case Some(x) => MyConst(x, construct(args.tail :_*))
//  }
//}
