package lectures.part2oop

object Generics extends App {

  class MyList[+A]{
    def add[B >: A](element: B): MyList[B] = ???
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic Methods
  object MyList{
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]


  // variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

//  No, Invariance
//  animalList.add(new Dog)  ??? HARD QUESTION.

  class InvariantList[A]
  val invariantAnimaList: InvariantList[Animal] = new InvariantList[Animal]

//  Contravariance
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

//  Bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
//  val newCage = new Cage(new Car)       // Won't work, because Car is not [Animal] subtype

}
