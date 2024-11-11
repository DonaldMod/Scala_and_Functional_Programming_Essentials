package lectures.part2oop

import playground.{Playground, PrinceCharming as Prince}

import java.sql
import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // Import the package
//  val princess = new Cinderella
//  val princess = new playground.Cinderella

  // packages are in hierarchy
  // matching the folder structure

  // Package Object

  sayHello
  println(SPEED_OF_LIGHT)


  // imports
  val prince = new Prince

  val date = new Date
//  val dateSql = new SqlDate(2009,02,21)


}
