package lecture.part4

object collections extends App {

  val number = List(1, 2, 3)
  val char1: Seq[Char] = List('a', 'b')

  val str = number.map(x => char1.map(y => "" + x + y))
  println(str)
  val dig = List(1.1, 1.2, 1.3)

  val y = number.foreach(x => {
    char1.foreach(c => x.toString + c.toString)
  })

  val t: Seq[String] = char1.map(c => "" + c)
  val x = number.flatMap(i => char1.flatMap(c => dig.map(d => "" + i + c + d)))
  println(x)
}
