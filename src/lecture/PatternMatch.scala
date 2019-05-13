package lecture

object PatternMatch extends App {

  def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(e1, e2) => s"( ${show(e1)} + ${show(e2)} )"
    case e: Product => s"( ${show(e.e1)} * ${show(e.e2)} )"
    case someting => s"found ${someting}"
  }

 println(show(Product(Sum(Number(1), Number(2)), Number(3))))

  val tuples = List((1,2), (3,4))

  val x =  for {
    (f, s) <- tuples
  } yield (f * s)

  println(x)
}


sealed trait Expr

case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

case class Product(e1: Expr, e2: Expr) extends Expr
