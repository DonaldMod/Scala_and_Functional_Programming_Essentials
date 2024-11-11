package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  //  println(x.length)

  //  val aWeirdValues: String = throw new NullPointerException()

  def getInt(withExceptions: Boolean) : Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  val potentialFail = try {
    getInt(true)
  }
  catch {
    case e: RuntimeException => println("Caught a Runtime Exception")
  }
  finally {
    println("finally")
  }

  println(potentialFail)

  //  class MyException extends Exception
  //  val exception = new MyException
  //
  //  throw exception

  //  // Out of memory error (OOM)
  //  val array = Array.ofDim(Int.MaxValue)

  //// StackOverflow (SO)
  //  def infinite: Int =
  //    1 + infinite
  //
  //  val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculatorException extends RuntimeException("Division by 0")

  object PockerCalculator {
    def add(x: Int, y: Int) =
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result

    def subtract(x: Int, y: Int) =
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result

    def multiply(x: Int, y: Int) =
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result

    def divide(x: Int, y: Int) =
      if (y == 0) throw new MathCalculatorException
      else x / y
  }

//  println(PockerCalculator.add(Int.MaxValue,1))
//  println(PockerCalculator.subtract(Int.MinValue,2))
  println(PockerCalculator.divide(2,0))

}
