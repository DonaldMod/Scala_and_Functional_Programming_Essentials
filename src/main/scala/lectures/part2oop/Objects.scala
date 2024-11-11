package lectures.part2oop

object Objects extends App {

  object Person{
//    Static/Class - level functionality
    val N_Eyes = 2
    def canFly: Boolean =
      false

    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String){
    // Instance-Level Functionality
  }

  println(Person.N_Eyes)
  println(Person.canFly)

  // Scala object is a SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)


  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val bobbie = Person.apply(mary, john)
  val bobbie1 = Person (mary, john)         // Because of apply method

  // Scala Applications is only a Scala Object with a very important method [Main]
  // def main(args: Array[String]): Unit

}
