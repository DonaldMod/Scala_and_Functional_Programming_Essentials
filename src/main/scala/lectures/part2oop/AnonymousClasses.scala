package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahhahahhah")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name. how can I help?")
  }

  val tim = new Person("Tim")
  tim.sayHi
  println(tim.getClass)

  val jim = new Person("Jim"){
    override def sayHi: Unit = println("Testing")
  }

  jim.sayHi
  println(jim.getClass)



  

}
