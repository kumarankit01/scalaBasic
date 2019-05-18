package lecture.afp

object PartialFunctions extends App {

  val aFunction = (x: Int) => x + 1

  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 44
    case 2 => 34
    case 4 => 123
  }

  println(aPartialFunction(1))
  println(aPartialFunction.isDefinedAt(3))

  //lift
  val lifted: Int => Option[Int] = aPartialFunction.lift

  println(lifted(2))

  val pfChain = aPartialFunction.orElse[Int, Int] {
    case 3 => 45
  }

  /**
    *
    */

  val aPartialFunction2: PartialFunction[String, Unit] = {
    case "dd" => println("dd")
    case "cc" => println("cc")
    case "rr" => println("asd")
    case _ => println("try again" + _)
  }
  //scala.io.Source.stdin.getLines().foreach(line => aPartialFunction2(line))

  val aManualFuntion = new PartialFunction[Int, Int] {
    override def isDefinedAt(x: Int): Boolean = x == 1 || x == 2 || x == 4


    override def apply(v1: Int): Int = v1 match {
      case 1 => 44
      case 2 => 34
      case 4 => 123
    }
  }

  println(aManualFuntion(1))
  println(aManualFuntion.isDefinedAt(34))
}
