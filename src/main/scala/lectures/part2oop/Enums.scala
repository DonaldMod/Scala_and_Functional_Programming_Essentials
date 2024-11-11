package lectures.part2oop

import lectures.part2oop.Enums.Permissions.{NONE, READ}

object Enums extends App {

  enum Permissions {
    case READ,
    WRITE,
    EXECUTE,
    NONE

    def openDocument: Unit =
      if (this == READ) println("opening document...")
      else println("reading not allowed.")
  }

  val somePermission: Permissions = Permissions.READ

  println(somePermission)

  somePermission.openDocument

  enum PermissionWithBits(bits: Int){
    case READ extends PermissionWithBits(4)   // 100
    case WRITE extends PermissionWithBits(2)  // 010
    case EXECUTE extends PermissionWithBits(1)  // 001
    case NONE extends PermissionWithBits(0)  // 000
  }

  val pwb = PermissionWithBits
  println(pwb)


  object PermissionWithBits {
    def fromBits(bits: Int) : PermissionWithBits =
      PermissionWithBits.NONE
  }

  val somePermissionOrdinal = somePermission.ordinal
  println(somePermissionOrdinal)

  val allPermissions = PermissionWithBits.values.toList    // Array of all possible values of the enum
  println(allPermissions)

  val readPermission: Permissions = Permissions.valueOf("READ")
  println(readPermission)


}
