package gens

import scala.util.Random
import CheckResult._

object Gen {

  def create[A](a: A): Gen[A] = Gen(seed => (seed, a))

  def flatMap[A, B](g: Gen[A])(f: A => Gen[B]): Gen[B] = Gen { seed =>
    val (nseed, a) = g.run(seed)
    f(a).run(nseed)
  }

  def map[A, B](g: Gen[A])(f: A => B): Gen[B] = flatMap(g)(create[B] _ compose f)

  def zip[A, B](ga: Gen[A], gb: Gen[B]): Gen[(A, B)] = for {
    a <- ga
    b <- gb
  } yield (a, b)

  def zip[A, B, C](ga: Gen[A], gb: Gen[B], gc: Gen[C]): Gen[(A, B, C)] = for {
    a <- zip(ga, gb)
    c <- gc
  } yield (a._1, a._2, c)

  def listOf[A](g: Gen[A], size: Int): Gen[List[A]] = Gen { seed =>
    (0 until size).foldLeft((seed, List[A]())) {
      case ((s, xs), _) =>
        val (ns, x) = g.run(s)
        (ns, x :: xs)
    }
  }

  val genInt: Gen[Int] = Gen(l => (l + 1, new Random(l).nextInt()))

  val genDouble: Gen[Double] = Gen(l => (l + 1, new Random(l).nextDouble()))

  val genChar: Gen[Char] = Gen(l => (l + 1, new Random(l).nextPrintableChar()))

  val genString: Gen[String] = map(genList(genChar)){ _.mkString("") }

  def genList[A](g: Gen[A]): Gen[List[A]] = flatMap(genInt) { i => listOf(g, i % 100) }

  def sample[A](g: Gen[A], size: Int = 10): List[A] = listOf(g, size).run(Random.nextLong())._2

  def forAll[A](g: Gen[A], n: Int = 100, seed: Long = Random.nextLong())(p: A => Boolean): CheckResult =
    listOf(g, 100).
      run(seed).
      _2.
      find { x => !p(x) }.
      fold(success) { a => failure(s"Failed for input: $a") }

  def forAll2[A, B](ga: Gen[A], gb: Gen[B], n: Int = 100, seed: Long = Random.nextLong())(p: (A, B) => Boolean): CheckResult = forAll(zip(ga, gb), n, seed) {
    case (a, b) => p(a, b)
  }
}

object CheckResult {
  def success: CheckResult = Success
  def failure(msg: String): CheckResult = Failure(msg)
}

sealed trait CheckResult

case object Success extends CheckResult

case class Failure(msg: String) extends CheckResult

case class Gen[A](run: Long => (Long, A)) {
  def map [B](f: A => B): Gen[B] = Gen.map(this)(f)
  def flatMap [B] (f: A => Gen[B]): Gen[B] = Gen.flatMap(this)(f)
}