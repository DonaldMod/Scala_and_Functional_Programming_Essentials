package lectures.part3fp

import java.util.Base64

object HOFsandCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  def nTimes (f: Int => Int, n: Int, x: Int) : Int =
    if(n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1

  println(nTimes(plusOne, 10, 1))


  def nTimesBetter(f: Int => Int, n: Int) : (Int => Int) =
    if (n <= 0) (x:Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)

  println(plus10(1))

  // Curries
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))


  def curriedFormatter(c: String)(x:Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  def toCurry(f: (Int, Int) => Int) : (Int => Int => Int) =
    x => y => f(x,y)

  def fromCurry(f: (Int => Int => Int)) : (Int, Int) => Int =
    (x,y) => f(x)(y)

//  FunctionX
  def compose[A,B,T](f: A => B, g: T => A) : T => B =
    x => f(g(x))

  def andThen[A,B,C](f: A => B, g: B => C) : A => C =
    x => g(f(x))

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)

  def add4 = superAdder2(4)

  println(add4(17))


  def simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4,17))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(4))
  println(ordered(4))

}
