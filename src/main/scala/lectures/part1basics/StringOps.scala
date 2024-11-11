package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString)
  println(aNumberString :+ 'z')
  println('a' +: aNumberString :+ 'z')
  println('a' + aNumberString + 'z')
  println(str.reverse)
  println(str.take(2))

  // Scala-specific: String interpolators

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val greeting1 = s"Hello, my name is $name and I am ${age + 1} years old"

  println(greeting)
  println(greeting1)

  // F-interpolators
  val speed = 1.2f
  val name1 = "David"
  val myth = f"$name1 can eat $speed%2.2f burgers per minute"

  println(myth)


  // Raw-Interpolator
  println(raw"This is a \n newline")

  val escaped = "This is a \n newline"

  println(raw"$escaped")
  }
