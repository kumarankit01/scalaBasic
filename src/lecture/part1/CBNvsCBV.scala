package lecture.part1

object CBNvsCBV extends App {

  def callByValue(x: Long) = {
    println("call by value : " + x)
    println("call by value : " + x)
  }

  def callByName(x: => Long) = {
    println("call by name : " + x)
    println("call by name : " + x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite: Int = 1 + infinite

  def test1(x: Int, y: Int) = println(x)

  //proving delayed execution
  def test2(x: Int, y: => Int) = println(x)

  //uncomment to see error
  //test1(34, infinite)
  test2(34, infinite)

  /*
      Here's an exercise for you: let's define

      def byName(n: => Int): Int = n + 1
      def byFunction(f: () => Int) = f() + 1
      def method: Int = 42
      def parenMethod(): Int = 42

      and try to call byName and byFunction with

      - a plain Int
      - parenMethod, with and without parentheses
      - method (hint: you can't call it with parentheses)
      - a lambda that returns 42
   */
  def byName(n: => Long): Long = n + 1

  def byFunction(f: () => Long) = f() + 1

  def method: Int = 42

  def parenMethod(): Int = 42

  println("byName(44) = "+byName(System.nanoTime()))
  println("byName(44) = "+byName(System.nanoTime()))
  println("byFunction(44) = "+byFunction(() => System.nanoTime()))
  println("byFunction(44) = "+byFunction(() => System.nanoTime()))
  parenMethod
  println(parenMethod + parenMethod())

  println(method)
}
