package lectures.part3fp

import scala.:+
import scala.util.Random

object Sequeces extends  App {

  // Seq
  val aSequence = Seq(1,4,3,2)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  val aRange: Seq[Int] = 1 to 10
  val aRange1: Seq[Int] = 1 until 10
  aRange.foreach(println)
  aRange1.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  // Lists
  val aList = List(1,2,3)
  val prepended = 42 :: aList
  val prepended1 = 42 +: aList
  println(prepended)
  println(prepended1)

  val appended = aList :+ 42
  println(appended)

  val apples5 = List.fill(5) ("apple")
  println(apples5)
  println(aList.mkString("-|-"))

  // Arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)
  threeElements.foreach(println)
  println(threeElements)

  numbers(2) = 0

  println(numbers)
  println(numbers.mkString(" "))

  // Arrays and Seq
  val numbersSeq: Seq[Int] = numbers
  println(numbersSeq)

  // Vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  val maxRuns = 1000
  val maxCapacity  = 1000000

  def getWriteTime(collection: Seq[Int]) : Double = {
    val r = new Random()
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      // operation
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numberList = (1 to maxCapacity).toList
  val numberVector = (1 to maxCapacity).toVector

  // Keeps reference to tail
  println(getWriteTime(numberList))
  // depth of the tree is small
  println(getWriteTime(numberVector))



}
