package lecture.part2

class oopBasic

object oopBasic extends App {

  val oop = new oopBasic

  println(oop)

  val person = new person("mary")

  //println(person.name)

  val person2 = new person2("mary")

  println(person2.name)
}

class person(name : String )

class person2(val name : String )

