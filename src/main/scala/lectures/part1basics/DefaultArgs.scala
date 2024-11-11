package lectures.part1basics

object DefaultArgs extends App {

  def trFact(num: Int, acc: Int = 1): Int =
    if(num <= 1) acc
    else trFact(num - 1, num * acc)

  val fact10 = trFact(10, 5)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit =
    println("saving picutre")

  savePicture(width = 80)

  /*
  1. Pass in every leading argument
  2. Name the arguments
   */


  savePicture()
}
