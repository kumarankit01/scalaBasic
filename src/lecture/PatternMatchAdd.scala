package lecture

object PatternMatchAdd extends App {

  object PatenMulti {
    def unapply(arg: Int): Option[String] = {
      if (arg < 10)
        Some("single digit")
      else if (arg % 2 == 0)
        Some("divis by 2")
      else
        Some("no prop")
    }
  }


  val n = 45
  val x = n match {
    case PatenMulti(n) => n
  }
  println(x)
   val y = n match {
     case SingleDigit() => "is single"
     case Even() => "even number"
     case _ => "no prop"
   }

  println(y)

}

object SingleDigit {
  def unapply(arg: Int): Boolean = arg < 10
}

object Even {
  def unapply(arg: Int): Boolean = arg % 2 == 0
}

