package lectures.part1basics

import lectures.part1basics.Expressions.i

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }

  println(factorial(10))
//  println(factorial(5000))

  def anotherFactorial(n: BigInt): BigInt = {
    def factHelper(x: BigInt, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }

  /*
  anotherFactorial(10) = factHelper(10,1)
  = factHelper(9,10 * 1)
  = factHelper(8, 9 * 10 * 1)
  = factHelper(7, 8 * 9 * 10 * 1)
  = ...
  = factHelper(2,3 * 4 * ... * 9 * 10 * 1)
  = factHelper(1, 2 * 3 * 4 * ... * 9 * 10 * 1)
   */
  println(anotherFactorial(5000))

  def aAnotherFact(num1: BigInt): BigInt =
    if (num1 <= 1) num1
    else num1 * aAnotherFact(num1 - 1)

  println(aAnotherFact(5000))

  def aAccFact(num: BigInt): BigInt = {
    def aAnotherFact(num1: BigInt, acc: BigInt): BigInt =
      if (num1 <= 1) acc
      else aAnotherFact(num1 - 1, num1 * acc)

    aAnotherFact(num, 1)
  }

  println(aAccFact(500))

  @tailrec
  def aConcatString(RepString: String, num: BigInt, acc: String): String =
    if (num < 1) acc
    else aConcatString(RepString, num - 1, RepString +  acc)

  println(aConcatString("Word ", 4, ""))


  def IsPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntil(t - 1, n % t != 0 && isStillPrime)

    isPrimeUntil(n / 2, true)
  }

  println(IsPrime(2003))
  println(IsPrime(629))

  def fibo(num1: Int): Int = {
    @tailrec
    def aFib(num: Int, last: Int, nextToLast: Int): Int = {
      if (num >= num1) last
      else aFib(num + 1, last + nextToLast, last)
    }

    if (num1 <= 2) 1
    else aFib(2,1,1)
  }

  println(fibo(8))

}
