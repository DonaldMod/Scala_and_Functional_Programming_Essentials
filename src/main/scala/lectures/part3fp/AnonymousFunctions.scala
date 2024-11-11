package lectures.part3fp

object AnonymousFunctions extends App {
  val doubler1 = new Function1[Int, Int]{
    override def apply(v1: Int): Int =
      v1 * 2
  }

  // Anonymous Functions (LAMBDA)
  val doubler = (x: Int) => x * 2

  // Multiple params in a lambda
  val adder = (a: Int, b: Int) => a+b

  // no param
  val justDoSomething = () => 3

  println(justDoSomething)    // function itself
  println(justDoSomething())  // call

  // Curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }
  println(stringToInt("85"))

//  MOAR Syntactic Sugar
  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int,Int) => Int = _ + _


  val superAdd = (x: Int) => (y:Int) => x + y
  println(superAdd(3)(4))



}
