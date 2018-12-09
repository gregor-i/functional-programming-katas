package reader

object Reader {
  def reader[A, B](f: A => B): Reader[A, B] = Reader (f)
  def ask[A]: Reader[A, A] = Reader(identity)
}

case class Reader[A, B](run: A => B) {
  def map[C](f: B => C): Reader[A, C] = Reader(f compose run)
  def flatMap[C](f: B => Reader[A, C]): Reader[A, C] = Reader { a =>
    f(run(a)).run(a)
  }
  def contramap[C](f: C => A): Reader[C, B] = Reader (run compose f)
  def local[C](f: C => A): Reader[C, B] = contramap(f)
}
