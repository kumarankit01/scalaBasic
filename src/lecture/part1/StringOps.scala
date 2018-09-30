package lecture.part1

object StringOps extends App {

  val name = "Ankit"
  val age = 27.5
  val a = "Hi, my name is $name and I am $age years old"
  val b = s"Hi, my name is $name and I am $age%1.4f  years old"
  val c = f"Hi, my name is $name and I am $age%4.1f years old"
  val d = raw"Hi, my name is $name and I am $age%1.4f  years old"
  println(a)
  println(b)
  println(c)
  println(d)

}
