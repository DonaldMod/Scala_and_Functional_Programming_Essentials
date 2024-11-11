package lectures.part3fp

object  MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // FlatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white")

//  List ("a1", "a2", ... , "d4")

  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  // "Interating"
  val combinations2 = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations2)

  // "Interating - If-Guard"
  val combinations3 = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations3)

  // foreach
  list.foreach(println)

  // for-comprehension {Making it easy to write chains}
  val forCombinations = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations)

  val forCombination2 = for {
    n <- numbers
    c <- chars
  } yield "" + n + c

  println(forCombination2)

  // Guards
  val forCombinations3 = for {
    n <- numbers  if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations3)

  for {
    n <- numbers
  } println(n)

  // Syntax overload
  val aapo = list.map {x =>
    x * 2
  }
  println(aapo)
  println(list.map(x => x * 2))

  


}
