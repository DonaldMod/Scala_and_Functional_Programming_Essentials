package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit ={
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infiniteRec(): Int =
    1 + infiniteRec()

  def printFirst(x: Int, y: => Int) =
    println(x)

//  printFirst(infiniteRec(), 34)
  printFirst(34, infiniteRec())

}
