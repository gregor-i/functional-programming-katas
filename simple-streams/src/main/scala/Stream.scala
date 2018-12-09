import java.util.Optional
import java.util.function.Supplier

sealed trait IStream[A]
case class SCons[A](head: Supplier[A], tail: Supplier[IStream[A]]) extends IStream[A]
case class SNil[A]() extends IStream[A]

object IStream{
  def create[A](args: A*): IStream[A] = if(args.nonEmpty)
    SCons(() => args.head, () => create(args.tail :_*))
  else
    SNil()

  def toList[A](stream: IStream[A]) : List[A] = stream match {
    case SCons(head, tail) => head.get() :: toList(tail.get())
    case SNil() => Nil
  }

  def prepend[A](head: Supplier[A], tail: Supplier[IStream[A]]) = SCons(head, tail)

  def map[A, B](stream: IStream[A], mapper: A => B): IStream[B] = stream match {
    case SCons(head, tail) => SCons(() => mapper(head.get()), () => map(tail.get(), mapper))
    case SNil() => SNil()
  }

  def filter[A](stream: IStream[A], predicate: A => Boolean): IStream[A] = stream match {
    case SCons(head, tail) =>
      val evalHead = head.get()
      if(predicate(evalHead))
        SCons(() => evalHead, () => filter(tail.get(), predicate))
      else
        filter(tail.get(), predicate)
    case SNil() => SNil()
  }

  def take[A](stream: IStream[A], n: Int): IStream[A] = stream match {
    case SCons(head, tail) if n > 0 => SCons(head, () => take(tail.get(), n-1))
    case _ => SNil()
  }

  def zip[A, B](left: IStream[A], right: IStream[B]): IStream[util.Tuple[A, B]] = (left, right) match{
    case (SCons(leftHead, leftTail), SCons(rightHead, rightTail)) => SCons(() => new util.Tuple(leftHead.get(), rightHead.get()), () => zip(leftTail.get(), rightTail.get()))
    case _ => SNil()
   }

  def iterate[A](seed: A, repeater: A => Optional[A]): IStream[A] = {
    val maybeNext = repeater(seed)
    if(maybeNext.isPresent)
      SCons(() => seed, () => iterate(maybeNext.get, repeater))
    else
      SCons(() => seed, () => SNil())
  }
}
