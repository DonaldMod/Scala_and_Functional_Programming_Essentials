package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)

  println(1 == x)

  println(!(1 == x))

  var aVariable = 2
  aVariable += 3
  println(aVariable)

//  Instructions (DO) vs Expressions (Value)
//  IF expression

  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  //  NEVER WRITE THIS AGAIN!!

  val aWeirdValue = (aVariable = 3) //Unit == void
  println(aWeirdValue)

//  Code Blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "good-bye"
}
  println(aCodeBlock)

//  val anotherValue = z + 1

  "hello world"
  println("hello world")

  val someValue = {
    2 < 3
  }

  println(someValue)

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }

  println(someOtherValue)


}
