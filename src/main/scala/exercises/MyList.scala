package exercises

import scala.collection.View.Zip

object ListTest extends App {
  val  list = new Cons(1, Empty)
  println(list.head())

  val list2 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list2.tail().head())

  println(list2.add(4).head())

  println(list2.toString)

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(5, new Cons(4, Empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala",  Empty))

  println(listOfIntegers)
  println(listOfStrings)

  println(listOfIntegers.map(elem => elem * 2).toString)

  println(listOfIntegers.filter(elem => elem % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem, new Cons(elem + 1, Empty)))).toString)

  println(cloneListOfIntegers == listOfIntegers)

  listOfIntegers.forEach(println)

  println(listOfIntegers)

  println(listOfIntegers.sort((x,y) => y - x))

  println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _))

  println(listOfIntegers.fold(0)(_ + _))

  val combination1 = for {
    a <- listOfIntegers
    b <- listOfStrings
  } yield a + "-" + b

  println(combination1)
}

abstract class MyList[+A] {

  def head() : A

  def tail() : MyList[A]

  def isEmpty() : Boolean

  def add[B >: A](num1: B) : MyList[B]

  def printElements: String

  override def toString: String =
    s"[$printElements]"

  def map[B](transformer: Function1[A,B]): MyList[B]

  def flatMap[B] (transformer: Function1[A, MyList[B]]) : MyList[B]

  def filter(predicate: A => Boolean) : MyList[A]

  def ++[B >: A](list: MyList[B]) : MyList[B]

  def forEach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int) : MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A,B) => C) : MyList[C]

  def fold[B](start: B) (operator: (B, A) => B) : B

}

case object Empty extends MyList[Nothing]{
  def head(): Nothing = throw new NoSuchElementException()

  def tail(): MyList[Nothing] = throw new NoSuchElementException()

  def isEmpty(): Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements : String = ""

  def map[B](transformer: Function1[Nothing, B]): MyList[B] = Empty

  def flatMap[B](transformer: Function1[Nothing, MyList[B]]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  def forEach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing, Nothing) => Int) = Empty

  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if(!list.isEmpty()) throw new RuntimeException("List do not have the same length")
    else Empty

  def fold[B](start: B) (operator: (B, Nothing) => B) : B  = start

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  def head(): A = h

  def tail(): MyList[A] = t

  def isEmpty(): Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String =
    if(t.isEmpty()) s"$h"
    else s"$h ${t.printElements}"

  def map[B](transformer: Function1[A, B]): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def flatMap[B](transformer: Function1[A, MyList[B]]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)


  def ++[B >: A](list: MyList[B]): MyList[B]  =
    new Cons(h, t ++ list)

  def forEach(f: A => Unit): Unit = {
    f(h)
    t.forEach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty()) new Cons(x, Empty)
      else if (compare(x, sortedList.head()) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head(), insert(x, sortedList.tail()))

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)

  }

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
    if (list.isEmpty()) throw new RuntimeException("List do not have the same length")
    else new Cons(zip(h, list.head()), t.zipWith(list.tail(), zip))

  /*
  [1,2,3].fold(0)(+) =
  [2,3].fold(1)(+) =
  [3].fold(3)(+) =
  [].fold(6)(+) =

   */
  def fold[B](start: B) (operator: (B, A) => B) : B =
    t.fold(operator(start, h))(operator)




}


