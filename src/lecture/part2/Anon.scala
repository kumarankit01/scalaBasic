package lecture.part2


object Anon extends App {

  abstract class Person {
    def greet
  }

  val anonPer = new Person {
    override def greet: Unit = println("Hi")
  }
  println(anonPer.getClass)


  class Car {
    def model = "model 3"
  }

  val myCar = new Car {
    override def model: String = "van"
  }

  println(myCar.getClass + "  " + myCar.model)

  trait Poison {
    def color
  }

  abstract class Snake

  val viper = new Snake with Poison {
    override def color = "green"
  }

  println(viper.getClass)

}
