package lectures.part4pm

import exercises.{Cons, Empty, MyList}

object AllThePatterns extends App {
  // 1 - Constants

  val x: Any = "Scala"
  val constants = x match
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"

  // 2 - match anything - 2.1 WIldcard
  val matchAnything = x match
    case _ =>

  // 2.2 Variable
  val mmatchAVariable = x match
    case something => s"I have found $something"

  // 3 - Tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match
    case (1,1) =>
    case (something,2) => s"I have found $something"

  //PMs can be Nested
  val nestedTuple = (1, (2,3))
  val matchANestedTuple = nestedTuple match
    case (_, (2, v)) =>

  // 4 - case classes - constructor pattern
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) =>

  // 5 - list patterns
  val aStandardList = List(1,2,3,42)
  val standardListMatching = aStandardList match
    case List(1,_,_,_) =>       // extractor
    case List(1,_*) =>      // List of arbitrary length
    case 1 :: List(_) =>      // Infix pattern
    case List(1,2,3) :+ 42 =>       // Infix pattern

  // 6 - Type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match
    case list: List[Int] =>         // explicit type specifier
    case _ =>

  // 7 - Name binding
  val namBindingMatch = aList match
    case nonEmptyList @ Cons(_, _) =>         // name binding => use the name later(here)
    case Cons(1, rest @ Cons(2, _)) =>        // Name binding inside patterns


  // 8 - multi-patterns
  val multiPattern = aList match
    case Empty | Cons(0, _) =>        // Compound pattern (multi-pattern)

  val secondElementSpecial = aList match
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>

  val numbers = List(1,2,3)
  val numbersMatch = numbers match
    case listOfStrings: List[String] => "a list of stings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""

  println(numbersMatch)
}
