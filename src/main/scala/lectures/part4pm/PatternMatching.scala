package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {
  //Switch on steriods

  val random = new Random
  val x = random.nextInt(10)

  val description = x match
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // _ = WILDCARD, IF not there will be a SCALA.MATCH error.

  println(x)
  println(description)

  case class Person(name: String, Age: Int)

  val bob = Person("Bob", 20)

  val greeting = bob match
    case Person(n,a) if a < 21 => s"Hi, my name is $n and I cannot drink in the US"
    case Person(n,a) => s"Hi, my name is $n and I am $a years old"
    case _ => "I do not know who I am"

  println(greeting)

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeShowParentheses (exp: Expr) = exp match
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => s"(${show(exp)})"

      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(3)), Number(4))))
  println(show(Sum(Prod(Number(2), Number(3)), Number(4))))



}


