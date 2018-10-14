trait Monad[F[_]] extends Functor[F]{
  def pure[A](a: A): F[A]
  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
  def map[A, B](data: F[A])(mapper: A => B): F[B] = flatMap(data)(mapper andThen pure)
}
