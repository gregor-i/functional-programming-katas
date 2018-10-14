import org.scalatest.{FunSuite, Matchers}

class TypeClassesSpec extends FunSuite with Matchers {
  // example
  test("define a functor for MyList") {
    val intList: MyList[Int] = MyConst(12, MyConst(13, MyConst(14, MyNil())))
    val stringList: MyList[String] = MyConst("12", MyConst("13", MyConst("14", MyNil())))

    MyListIsFunctor.map(intList)(_.toString) shouldBe stringList
  }

//  test("define a sealed trait with case classes for option") {
//    MyNone(): MyOption[Int]
//    MySome(15): MyOption[Int]
//    MyNone(): MyOption[String]
//    MySome("15"): MyOption[String]
//    succeed
//  }
//
//  test("define a functor for MyOption") {
//    MyOptionIsFunctor.map(MySome(15))(_.toString) shouldBe MySome("15")
//    MyOptionIsFunctor.map(MyNone())(_.toString) shouldBe MyNone()
//  }
//
//  test("define a trait for monads") {
//    val x: Monad[MyOption] = null
//    succeed
//  }
//
//  test("define a monad for MyOption") {
//    MyOptionIsMonad: Monad[MyOption]
//    succeed
//  }
//
//  test("add a method 'pure' to the monad type class.") {
//    MyOptionIsMonad.pure(15) shouldBe MySome(15)
//    MyOptionIsMonad.pure("15") shouldBe MySome("15")
//    MyOptionIsMonad.pure(true) shouldBe MySome(true)
//  }
//
//  test("add a method 'flatMap' to the monad type class.") {
//    val example = MyOptionIsMonad.pure(15)
//    MyOptionIsMonad.flatMap(example)(_ => MySome("15")) shouldBe MySome("15")
//    MyOptionIsMonad.flatMap(example)(b => if (b % 2 == 0) MySome(true) else MyNone[Boolean]()) shouldBe MyNone()
//  }
//
//  test("let Monad extend Functor. Use only methods from Monad to define map.") {
//    MyOptionIsMonad: Functor[MyOption]
//    MyOptionIsMonad.map(MySome(1))(_ + 2) shouldBe MySome(3)
//  }
//
//  test("define a monad for MyList"){
//    val example1 = MyListIsMonad.pure(12)
//    MyListIsMonad.flatMap(example1)(e => MyConst(e, MyConst(e, MyNil()))) shouldBe MyConst(12, MyConst(12, MyNil()))
//
//    val example2 = MyListIsMonad.pure(21)
//    MyListIsMonad.flatMap(example2)(e => MyConst(e, MyConst(e, MyNil()))) shouldBe MyConst(21, MyConst(21, MyNil()))
//  }
}
