trait Functor[F[_]] {
  def map[A, B](data: F[A])(mapper: A => B): F[B]
}
