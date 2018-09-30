package lecture.part2

object oopBasicPart2 extends App {

}

class Author(firstName: String, surname: String, val year: Int) {
  def fullName = firstName + surname
}

class Novel(name: String, release: Int, author: Author) {
  def authorAge = author.year - release

  def isWrittenBy = author.fullName

  def copy(year: Int) = new Novel(this.name, year, this.author)
}

class Counter(count: Int = 0) {

  def increment(x: Int) = new Counter(this.count + x)

  def decrement(x: Int) = new Counter(this.count - x)
}
