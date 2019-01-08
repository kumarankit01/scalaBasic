package lecture.part3

object HofsAndCurries extends App {

  val superFuntion: (Int, ((String, Int) => Int)) => (Int => Int) = null

  @scala.annotation.tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n == 0) x
    else nTimes(f, n - 1, f(x))
  }

  val plusOne: Int => Int = _ + 1

  val multiplyBy2: Int => Int = _ * 2

  //  println("curry => "+plusOne(2)(multiplyBy2(2)))
  println(nTimes(multiplyBy2, 10, 1))

  def nTimesBetter(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))
  }

  val plus10: Int => Int = nTimesBetter(plusOne, 10)

  println("plus 10 = " + plus10(1))

  //curried
  val superAdderT1: Int => (Int => Int) = (x: Int) => (y: Int) => x + y

  def superAdderT2 = new Function[Int, Function1[Int, Int]] {
    override def apply(x: Int): Int => Int = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  def superAdderT3(x: Int)(y: Int): Int = x + y

  superAdderT3(3)(_)

  val add3Again: Int => Int = superAdderT2(3)
  println(add3Again(10))


  val add3New: Int => Int = superAdderT3(3)

  println(add3New(10))
  // val x: (Int, Int) => Int = _ + _

  val add3: Int => Int = superAdderT1(3) //f(y) =  (3 + y)

  println(add3(10)) //13

  def toCurry(f: (Int, Int) => Int): Int => Int => Int = x => y => f(x, y)

  def met(a: Int)(b: String): String = {
    a * 2 +" "+ b
  }

  val sWith4: String => String = met(2)(_)

  println(sWith4("tommy"))

  val add = toCurry(_ + _)

  val plus4: Int => Int = add(4)

  println("plus 4 = " + plus4(2))

  //def test(f: Int => Int): Int => Int = x => y => x * 2

  val fx: Int => Int => Int = toCurry((_ + _))
  println(fx(2)(3))

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = (x, y) => f(x)(y)

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  def andThen(f: Int => Int, g: Int => Int): Int => Int = x => g(f(x))

  val c: (Int => Int, Int => Int) => Int => Int = compose(_, _)
  val tt: Int => Int = c(_ * 2, _ * 3)
  println(tt(2))

}
