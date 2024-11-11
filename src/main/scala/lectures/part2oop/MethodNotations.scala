package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String,  favoriteMovie: String, Age: Int = 0){

    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"

    def unary_! : String =
      s"$name, what the heck?!"

    def isAlive: Boolean =
      true

    def apply(): String =
      s"Hi, my name is $name and I like $favoriteMovie"

    def +(nickName: String): Person =
      new Person(s"$name $nickName", favoriteMovie)

    def unary_+ : Int  =
      Age + 1

    def learns(learn: String) : String =
      s"$name learns $learn"

    def learnsScala: String =
      this learns "Scala"

    def apply(num: Int) : String =
      s"$name watched $favoriteMovie $num times"
  }

  val  mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")   // Equivalent
  // infix notation OR operator notation

  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  // Prefix notation > Unary Operators
  val x = -1  // equivalent with 1.unary_-
  val y = 1.unary_-
  // Unary_ prefix only work with - + ~ !

  println(!mary)
  println(mary.unary_!)


  // Postfix notation
  println(mary.isAlive)


  // Apply
  println(mary.apply())
  println(mary())


  // Exercises
  println((mary + "The rockstar") ())
  println(+mary)
  println(mary.learnsScala)
  println(mary.apply(2))
  println(mary apply 2)

}
