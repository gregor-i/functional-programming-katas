import java.util.Optional

import org.scalatest._

class MyListSpec extends WordSpec with Matchers {

  /*

  "List (data structure)" should {
    "have a simple constructor" in {
      val empty: MyList[Int] = new MyNil()
      val oneElement: MyList[Int] = new MyConst(1, new MyNil())
      succeed
    }

    "and the constructor is generic" in {
      val stringList: MyList[String] = new MyConst("a", new MyNil())
      val intList: MyList[Int] = new MyConst(1337, new MyNil())
      succeed
    }

    "the fields are public" in {
      val tail = new MyNil[Int]()
      val intList: MyConst[Int] = new MyConst[Int](1337, tail)
      intList.head shouldBe 1337
      intList.tail shouldBe tail
    }

    "and correctly typed" in {
      val stringList = new MyConst[String]("a", new MyNil())
      val intList = new MyConst[Int](1337, new MyNil())
      val StringListHead: String = stringList.head
      val intListHead: Int = intList.head
    }

    "and final" in {
      val intList: MyConst[Int] = new MyConst(1337, new MyNil())
      "intList.head = 1256" shouldNot compile
      "intList.tail = new MyNil[Int]()" shouldNot compile
    }
  }

  "List (collection operations)" should {
    val example1: MyList[String] = new MyConst("a", new MyConst("b", new MyNil()))

    "implement a length" in {
      example1.length shouldBe 2
    }

    "implement a find" in {
      example1.find(_ == "b") should (be(Optional.of("b")) or be(Some("b")))
      example1.find(_ == "c") should (be(Optional.empty()) or be(None))
    }

    "implement access with index" in {
      example1.get(0) should (be(Optional.of("a")) or be(Some("a")))
      example1.get(1) should (be(Optional.of("b")) or be(Some("b")))
      example1.get(2) should (be(Optional.empty()) or be(None))
    }

    "implement a useful equals" in {
      example1.equals(example1) shouldBe true
      new MyNil[Int]().equals(new MyNil[Int]()) shouldBe true

      new MyConst(1, new MyNil()).equals(new MyNil[Int]()) shouldBe false
      example1.equals(null) shouldBe false
      example1.equals("some string") shouldBe false
    }

    "implement prepend" in {
      example1.prepend("c") shouldBe new MyConst("c", example1)
      new MyNil[Int]().prepend(15) shouldBe new MyConst(15, new MyNil())
    }

    "implement append" in {
      example1.append("c") shouldBe new MyConst("a", new MyConst("b", new MyConst("c", new MyNil())))
      new MyNil[Int]().append(15) shouldBe new MyConst(15, new MyNil())
    }

    "implement concat" in {
      example1.concat(example1) shouldBe new MyConst("a", new MyConst("b", new MyConst("a", new MyConst("b", new MyNil()))))
      new MyNil[Int]().concat(new MyNil[Int]()) shouldBe new MyNil()
    }
  }

  "List (syntax sugar)" should{
    val example1: MyList[String] = new MyConst("a", new MyConst("b", new MyNil()))

    "implement a nice way stringify lists" in {
      example1.join(":") shouldBe "a:b"
      example1.join(":+:") shouldBe "a:+:b"
    }

    "overload the method to supply pre- and post-fix" in{
      example1.join("[", ":", "]") shouldBe "[a:b]"
      example1.join("(", ":+:", ")") shouldBe "(a:+:b)"
    }

    "implement a nicer toString" in {
      example1.toString shouldBe "MyList(a, b)"
      new MyNil[Int]().toString shouldBe "MyList()"
    }

    "supply function to construct a with list with var args" in {
      MyList.construct("a", "b") shouldBe example1
    }
  }


  "List (monadic and FP operations)" should{
    val example1: MyList[String] = MyList.construct("a", "b")

    "implement map" in {
      example1.map(s => s.charAt(0)) shouldBe MyList.construct('a','b')
      example1.map(s => s + "!") shouldBe MyList.construct("a!", "b!")
    }

    "implement filter" in {
      example1.filter(s => s == "b") shouldBe MyList.construct("b")
    }

    "implement foreach" in {
      var counter = 0
      example1.foreach(s => counter += 1 )
      counter shouldBe 2
    }

    "implement flatMap" in {
      example1.flatMap(s1 => example1.map(s2 => s1 + s2))
        .shouldBe(MyList.construct("aa", "ab", "ba", "bb"))

      example1.flatMap(_ => example1).length shouldBe 2 * 2
      example1.flatMap(_ => example1).flatMap(_ => example1).length shouldBe 2 * 2 * 2
    }

    "having flatMap, map and filter, it is possible to use for" in {
      (for{
        s1 <- example1
        s2 <- example1
      } yield s1 + s2) shouldBe MyList.construct("aa", "ab", "ba", "bb")
    }

    "implement a fold" in {
      example1.fold[String]("", (s1, s2) => s1 + s2) shouldBe "ab"
      example1.fold[Int](0, (s, l) => s.length + l) shouldBe 2
    }
  }



  */
}
