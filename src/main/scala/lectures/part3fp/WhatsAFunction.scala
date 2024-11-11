package lectures.part3fp

object WhatsAFunction extends App {

  val doubler = new MyFunction[Int, Int]{
    override def apply(element: Int): Int =
      element * 2
  }

  println(doubler(2))

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int =
      string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder = new Function2[Int, Int, Int]{
    override def apply(a: Int, b: Int): Int =
      a + b
  }

  println(adder(4,4))

  val myFuncTest = new MyFunction2[String, String, String] {
    override def apply(string: String, string2: String): String =
      string + string2
  }
  println(myFuncTest("Life is pretty"," long, never give up."))

  def concatenator: (String, String) => String = new Function2[String,String, String]{
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concatenator("Hello ", "Scala"))

  // Function1[Int, Function1[Int, Int]
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function[Int, Function1[Int,Int]]{
    override def apply(v1: Int): Int => Int = new Function[Int, Int]{
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val superAdd1 = (v1: Int) => (v2: Int) => v1 + v2

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(4)(2))
  println(superAdd1(4)(2))
}

trait MyFunction[A, B] {
  def apply(element: A) : B
}

trait MyFunction2[A ,B ,C]{
  def apply(string: A, string2: B) : C
}