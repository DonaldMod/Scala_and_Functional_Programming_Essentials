package lectures.part2oop

object AbstractDataTypes extends App {
  // Abstract Members

  abstract class Animal {
    val creatureType: String = "Wild"
    def eat: Unit
  }

  class Dog extends Animal{
    override val creatureType: String = "Canine"

    override def eat: Unit = println("crunch crunch")
  }

  //  traits
  trait Carnivore{
    def  eat (animal: Animal): Unit
    val preferredMeal: String = "Fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"

    override def eat: Unit = println("nomnom")

    override def eat(animal: Animal): Unit = println(s"I am a croc and I am eating ${animal.creatureType}")
 
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)
}


