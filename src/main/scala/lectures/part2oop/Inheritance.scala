package lectures.part2oop

object Inheritance extends App {

  sealed class Animal {
    val creatureType = "Wild"
    def eat =
      println("nomnom")
  }

  class Cat extends Animal{
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.eat
  cat.crunch

  // Contructors
  class Person(name: String, age: Int){
    def this(name: String) =  this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding
  class Dog(override val creatureType: String) extends Animal{
//    override val creatureType: String = "domestic"
    override def  eat =
      super.eat
      println("crunch, crunch")
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (Broad - > Polymorphism)
  val unknownAnimal: Animal = new Dog("K9")


  // Super

  // Prevent overrides



}
