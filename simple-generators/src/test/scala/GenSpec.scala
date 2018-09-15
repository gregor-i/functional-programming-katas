import gens.{CheckResult, Gen}
import org.scalatest.{Matchers, WordSpec}

import scala.util.Random
import gens.Gen._

class GenSpec extends WordSpec with Matchers {

  "A Generator" should {

    val seed = Random.nextLong()

    "run by being given a seed and producing a value together with the next seed" in {
//      val elm = 1
//      val seed = Random.nextLong()
//      val gen = Gen(l => (l, elm))
//
//      val (ns, a) = gen.run(seed)
//      ns shouldBe seed
//      a shouldBe elm
    }

    "create a simple generator returning some value for some seed" in {
//      val elm = "Hello"
//      create(elm).run(seed)._2 == elm
    }

    "be able to generate simple integers" in {
//      genInt.run(seed)._2.isInstanceOf[Int] shouldBe true
    }

    "generate simple double values" in {
//      genDouble.isInstanceOf[Gen[Double]] shouldBe true
//      genDouble.run(seed)._2.isInstanceOf[Double] shouldBe true
    }

    "not generate the same value for the same seed" in {
//      genInt.run(seed)._2 shouldBe genInt.run(seed)._2
    }

    "not generate the same seed and value in a row" in {
//      val (ns, a) = genInt.run(seed)
//      val (nns, b) = genInt.run(ns)
//
//      seed should not be ns
//      ns should not be nns
//      nns should not be seed
//      a should not be b
    }

    "generate different values given different seeds" in {
//      val seed2 = Random.nextLong()
//
//      genInt.run(seed)._2 should not be genInt.run(seed2)._2
    }

    "generate lists of values given a generator of one value" in {
//      val i = 1
//
//      genList(genInt).isInstanceOf[Gen[List[Int]]] shouldBe true
//      genList(genInt.map(_ => i)).run(seed)._2.forall(_ == i) shouldBe true
    }

    "have some sample function, that creates lists of values of a fixed size given a generator" in {
//      val i = 1
//      sample(genInt.map(_ => i), 10) shouldBe (0 until 10).map(_ => i).toList
    }

    "allow changes to the values it's generating" in {
//      val const = "hello"
//
//      map(genInt) { i => i.toChar }.run(seed)._2.isInstanceOf[Char] shouldBe true
//      map(genInt) { _ => const }.run(seed)._2 shouldBe const
    }

    "be composable with other generators" in {
//      val i = 1
//      val d = 1.0
//
//      flatMap(genInt) { i =>
//        genDouble.map { d => (i, d) }
//      }.isInstanceOf[Gen[(Int, Double)]] shouldBe true
//
//      flatMap(genInt.map(_ => i)) { xi =>
//        genDouble.map(_ => d).map { xd => (xi, xd) }
//      }.run(seed)._2 shouldBe(i, d)
    }

    "be able to fuse with other generators to produce a product of both" in {
//      val i = 1
//      val d = 1.0
//
//      zip(genInt, genDouble).isInstanceOf[Gen[(Int, Double)]] shouldBe true
//      zip(genInt.map(_ => i), genDouble.map(_ => d)).run(seed)._2 shouldBe(i, d)
    }

    "generate simple chars" in {
//      genChar.isInstanceOf[Gen[Char]] shouldBe true
//      genChar.run(seed)._2.isInstanceOf[Char] shouldBe true
    }

    "generate simple strings" in {
//      genString.isInstanceOf[Gen[String]] shouldBe true
//      genString.run(seed)._2.isInstanceOf[String] shouldBe true
    }

    "test the validity of some property given a generator of values for that property" in {
//      forAll(genInt, 100, seed) { i => i + 1 - 1 == i } shouldBe CheckResult.success
    }

    "test the validity of some property using the same values given the same seed" in {
//      var parasite1 = List[Int]()
//      var parasite2 = List[Int]()
//
//      forAll(genInt, 100, seed) { i =>
//        parasite1 = i :: parasite1
//        i + 1 - 1 == i
//      }
//
//      forAll(genInt, 100, seed) { i =>
//        parasite2 = i :: parasite2
//        i + 1 - 1 == i
//      }
//
//      parasite1 shouldBe parasite2
    }

    "test the validity of some property using two generators" in {
//      forAll2(genInt, genInt, 100, seed) { (a, b) => a + b == b + a } shouldBe CheckResult.success
    }

    "test the validity of some property, fail when it doesn't hold and return a message with the input where it first failed" in {
//      val i = 1
//
//      forAll(genInt.map(_ => i), 100, seed) { x => x + 1 - 1 == x + 1 } shouldBe CheckResult.failure(s"Failed for input: $i")
    }
  }
}
