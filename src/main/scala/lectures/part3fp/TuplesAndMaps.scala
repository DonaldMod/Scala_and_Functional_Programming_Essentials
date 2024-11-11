package lectures.part3fp

import java.lang.annotation.Target
import java.net.NetworkInterface

object TuplesAndMaps extends App {

  val aTuple = new Tuple2(2, "Hello, Scala")
  val aTuple1 = Tuple2(2, "Hello, Scala")
  val aTuple2 = (2, "Hello, Scala")

  println(aTuple._1)
  println(aTuple._2)
  println(aTuple.copy(_2 = "Goodbye Java"))
  println(aTuple.swap)

//  Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), ("Daniel", 789), "Pauline" -> 963)
  val phoneBook1 = Map(("Jim", 555), ("Daniel", 789), "Pauline" -> 963).withDefaultValue(-1)

  println(phoneBook)
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook1("Mary"))


  // Add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phoneBook + newPairing
  println(newPhonebook)

  // Functionals on maps
  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))
  println(phoneBook.view.filterKeys(x => x.startsWith("J")).toMap)
  println(phoneBook.view.mapValues(numbeer => numbeer * 10).toMap)
  println(phoneBook.view.mapValues(numbeer => "02245-" + numbeer).toMap)

  // Conversions
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob","James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))


  val aTuple3 = Map("Jim" -> 555, "JIM" -> 900, ("Paul", 59878))

  println(aTuple3)
  println(aTuple3.map(test => test._1.toLowerCase() -> test._2))

  def add(network: Map[String, Set[String]], person: String) : Map[String, Set[String]] =
    network + (person -> Set())


  def friend(network: Map[String, Set[String]], a: String, b: String) : Map[String, Set[String]] =
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))


  def unfriend(network: Map[String, Set[String]], a: String, b: String) : Map[String, Set[String]] =
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))

  def remove(network: Map[String, Set[String]], person: String) : Map[String, Set[String]] =
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]) : Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")

  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String) : Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]) : String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(network))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]) : Int =
    network.view.filterKeys(k => network(k).isEmpty).toMap.size

  println(nPeopleWithNoFriends(network))
  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String) : Boolean =
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]) : Boolean =
      if(discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }

    bfs(b, Set(), network(a) + a)

  println(socialConnection(testNet, "Mary", "Jim"))
  println(socialConnection(network, "Mary", "Bob"))

  

}
