import java.util.Optional

import org.scalatest._

/**
  * README:
  *
  * This spec holds the exercises.
  * To do this kata you should uncomment the specs one by one and make the spec green.

  * The specs are split into parts.
  * It should be possible to complete each part without implementing methods of the other parts. (except Part0)
  * The parts are ordered by difficulty.
  *
  * Part0 : data structure
  * Part1 : collection operations
  * Part2 : monadic and FP operations
  * Part3 : syntax sugar
  *
  *
  * Happy Coding!
  *
  */

class MyListSpec extends WordSpec with Matchers {


  "List (data structure)" should {
//    "have a simple constructor" in {
//      val empty: MyList[Int] = new MyNil()
//      val oneElement: MyList[Int] = new MyConst(1, new MyNil())
//      succeed
//    }
//
//    "and the constructor is generic" in {
//      val stringList: MyList[String] = new MyConst("a", new MyNil())
//      val intList: MyList[Int] = new MyConst(1337, new MyNil())
//      succeed
//    }
//
//    "the fields are public" in {
//      val tail = new MyNil()
//      val intList: MyConst[Int] = new MyConst(1337, tail)
//      intList.head shouldBe 1337
//      intList.tail shouldBe tail
//    }
//
//    "and correctly typed" in {
//      val stringList = new MyConst[String]("a", new MyNil())
//      val intList = new MyConst[Int](1337, new MyNil())
//      val StringListHead: String = stringList.head
//      val intListHead: Int = intList.head
//    }
//
//    "and final" in {
//      val intList: MyConst[Int] = new MyConst(1337, new MyNil())
//      "intList.head = 1256" shouldNot compile
//      "intList.tail = new MyNil[Int]()" shouldNot compile
//    }
  }

  "List (collection operations)" should {
//    val example1: MyList[String] = new MyConst("a", new MyConst("b", new MyNil()))
//
//    "implement a length" in {
//      example1.length shouldBe 2
//    }
//
//    "implement a find" in {
//      example1.find(_ == "b") shouldBe Optional.of("b")
//      example1.find(_ == "c") shouldBe Optional.empty
//    }
//
//    "implement access with index" in {
//      example1.get(0) shouldBe Optional.of("a")
//      example1.get(1) shouldBe Optional.of("b")
//      example1.get(2) shouldBe Optional.empty()
//    }
//
//    "implement a useful equals" in {
//      example1.equals(example1) shouldBe true
//      new MyNil[Int]().equals(new MyNil[Int]()) shouldBe true
//
//      new MyConst(1, new MyNil()).equals(new MyNil[Int]()) shouldBe false
//      example1.equals(null) shouldBe false
//      example1.equals("some string") shouldBe false
//    }
//
//    "implement prepend" in {
//      example1.prepend("c") shouldBe new MyConst("c", example1)
//    }
//
//    "implement append" in {
//      example1.append("c") shouldBe new MyConst("a", new MyConst("b", new MyConst("c", new MyNil())))
//    }
//
//    "implement concat" in {
//      example1.concat(example1) shouldBe new MyConst("a", new MyConst("b", new MyConst("a", new MyConst("b", new MyNil()))))
//    }
  }



  "List (monadic and FP operations)" should{
//    val example1: MyList[String] = new MyConst("a", new MyConst("b", new MyNil()))
//
//    "implement map" in {
//      example1.map(s => s.charAt(0)) shouldBe new MyConst('a', new MyConst('b', new MyNil()))
//    }
//
//    "implement foreach" in {
//      var counter = 0
//      example1.foreach(s => counter += 1 )
//      counter shouldBe 2
//    }
//
//    "implement flatMap" in {
//      example1.flatMap(s1 => example1.map(s2 => (s1, s2)))
//        .shouldBe(new MyConst(("a", "a"), new MyConst(("a", "b"), new MyConst(("b", "a"), new MyConst(("b", "b"), new MyNil())))))
//    }
//
//    "implement a fold" in {
//      example1.fold[String]("", (s1, s2) => s1 + s2) shouldBe "ab"
//    }
  }


  "List (syntax sugar)" should{
//    val example1: MyList[String] = new MyConst("a", new MyConst("b", new MyNil()))
//
//    "implement a nice way stringify lists" in {
//      example1.join(":") shouldBe "a:b"
//      example1.join(":+:") shouldBe "a:+:b"
//    }
//
//    "overload the method to supply pre- and post-fix" in{
//      example1.join("[", ":", "]") shouldBe "[a:b]"
//      example1.join("(", ":+:", ")") shouldBe "(a:+:b)"
//    }
//
//    "implement a nicer toString" in {
//      example1.toString shouldBe "MyList(a, b)"
//      new MyNil[Int]().toString shouldBe "MyList()"
//    }
//
//    "supply function to construct a with list with var args" in {
//      MyList.construct("a", "b") shouldBe example1
//    }
  }
}