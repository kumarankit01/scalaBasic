package lecture.part2

object syntaticSugar extends App {

  class Person(val name: String, favMovie: String, val age: Int = 10) {

    def +(nick: String): Person = new Person(name = this.name + " ( " + nick + " )", this.favMovie, this.age)

    def unary_+ : Person = new Person(name = this.name, this.favMovie, this.age + 1)

    def learns(lang : String) = s"${this.name} learns $lang"

    def learnScala = learns("scala")

    def apply(watched: Int): String = s"${this.name} learns ${this.favMovie} $watched times"
  }


  val mary = new Person("Mary", "Inception")

  val rckstar = mary + "the rockstar"
  println(rckstar.name)

  val unary = +mary
  println(unary.age)

  println(unary learnScala)

  println(unary(2))

}
