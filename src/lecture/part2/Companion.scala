package lecture.part2

object Companion extends App {

  object Person {
    def apply(name: String, value: String): Person = new Person(name, value)

    def apply(name: String): Person = new Person(name, "test")
  }

  class Person(val name: String, value: String) {

    override def equals(obj: scala.Any): Boolean = super.equals(obj)
  }

  val x = Person
  val y = Person

  val z = ???
  println(x == y)

  val x1 = new Person("a", "a")
  val y1 = new Person("a", "a")

  println(x1 == y1)

  val mary = Person("mary")
  val jin = Person("Jin", "zoo")
}



