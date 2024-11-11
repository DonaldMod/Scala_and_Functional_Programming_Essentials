package lectures.part2oop

import scala.language.postfixOps

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val animal = new Animal("Pete", "Pitbull", 4)
  println(animal.num)
  animal.dogCall("Toby")
  animal.dogCall()

  val writer = new Writer("John", "Modise", 2003)
  println(writer.fullName())

  val novel = new Novel("Cloud Book", 2015, writer)
  println(novel.authorAge())
  println(novel.isWrittenBy(writer))

  val counter = new Counter
  counter.Increment().printCustom()
  counter.Increment().Increment().Increment().printCustom()
  counter.Decrement().Decrement().printCustom()
  counter.Increment(10).printCustom()

}

// constructor
class Person(name: String, val age: Int) {
  //body
  val x = 2

  println(1 + 3)

  def greet(name: String): Unit =
    println(s"${this.name} says: Hi, $name")

  def greet(): Unit =
    println(s"Hi. I am ${this.name}")

    // multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")
}

class Animal(name: String, species: String, Age: Int) {
  val num = 2

  println(7 + 7)

  def dogCall(name: String): Unit =
    println(s"Roll over ${name}, and bark at ${this.name}")

  def dogCall(): Unit =
    println(s"Dogs always bark at ${this.name}, who is ${this.Age} years old from the ${this.species} family.")


}

class Writer(firstName: String, Surname: String, val YOB:Int){
  def fullName(): String =
    s"${this.firstName} ${this.Surname}"

}

class Novel(name: String, yearOfRelease: Int, Author: Writer){

  def authorAge(): String =
    s"The author's age is ${yearOfRelease - Author.YOB} year old"

  def isWrittenBy(Author: Writer): String =
//    Author == this.Author
      if (Author == this.Author) s"The book is written by ${this.Author.fullName()}, so it is ${Author == this.Author}!"
      else s"It is ${Author == this.Author}"

  def newYOR(YoR: Int): Novel = new Novel(name, YoR, Author)
}

class Counter(val num: Int = 0){
  def currentCount(): Int =
    this.num

  def Increment() =
    println("Incrementing")
    new Counter(num + 1)

  def Decrement() =
    println("Decrementing")
    new Counter(num - 1)

  def Increment(x: Int): Counter =
    if(x <= 0) this
    else Increment().Increment(x - 1)

  def Decrement(x: Int): Counter =
    if(x <= 0) this
    else Decrement().Decrement(x - 1)

  def printCustom() =
    println(num)
}


// class parameters are NOT FIELDS