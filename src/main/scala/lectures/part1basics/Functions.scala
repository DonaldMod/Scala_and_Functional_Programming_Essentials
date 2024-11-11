package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
//  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n:Int): String =
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)

  println(aRepeatedFunction("hello", 3))

  def aDonTest(aTestString: String, n: Int): String =
    if (n == 1) aTestString
    else aTestString + " " + aDonTest(aTestString, n-1)

  println(aDonTest("yet", 10))

  def aFunctiionWithSideEffects (aString: String): Unit =
    println(aString)

  aFunctiionWithSideEffects("Tough")

  def aBigFunction (n:Int): Int =
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)

  def aGreetingFunc(Name: String, Age: Int): String =
    s"Hi, my name is ${Name} and I am ${Age} years old"

  println(aGreetingFunc("Abraham", 4))

  def aFactorialFunction(n2: BigInt, n: Int): BigInt =
    if (n == 1) n2
    else aFactorialFunction(n * n2, n-1)

  println(aFactorialFunction(1, 8))

//    1 * 2 * 3...  5 > 120


  def aSideFactor(x: Int, x1:BigInt): BigInt =
    if (x == 1) x1
    else aSideFactor(x-1, x1 * x)

  println(aSideFactor(7, 1))


  def testRecurs1(num1: Int, num2: BigInt): BigInt =
    if (num1 == 1) num2
    else testRecurs1(num1 - 1, num2 * num1)

  println(testRecurs1(5, 1))

  def aFactorial (n: Int): Int =
    if (n <= 0) 1
    else n * aFactorial(n-1)

  println(aFactorial(5))

  def aFibonacci (num1: Int): Int =
    if (num1 <= 2) 1
    else aFibonacci(num1 - 1) + aFibonacci(num1 - 2)

  println(aFibonacci(8))

  def isPrime(n: Int): Boolean = {
    if (n <= 1) {
      false  // Numbers less than or equal to 1 are not prime
    } else {
      // Check divisibility from 2 to sqrt(n)
      !(2 to math.sqrt(n).toInt).exists(i => n % i == 0)
    }
  }

  println(isPrime(5))

  def isAPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))


}



