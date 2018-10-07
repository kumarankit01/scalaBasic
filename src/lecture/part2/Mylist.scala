package lecture.part2

abstract class Mylist[+A] {

  def head: A

  def tail: Mylist[A]

  def isEmpty: Boolean

  def add[B >: A](value: B): Mylist[B]

  override def toString: String = s"[ " + getElement + " ]"

  final def getElement: String = {
    if (tail.isEmpty)
      "" + head
    else
      head + " " + tail.getElement
  }
}

class Node[+A](val value: A, val next: Mylist[A] = Empty) extends Mylist[A] {
  override def head: A = value

  override def tail: Mylist[A] = next

  override def isEmpty: Boolean = false

  override def add[B >: A](value: B): Mylist[B] = new Node[B](value, this)
}

object Empty extends Mylist[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: Mylist[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](value: B): Mylist[B] = new Node[B](value, Empty)
}


object ListTest extends App {
  val list: Node[Int] = new Node(1)
  println(list.toString)
  val with2 = list.add(2)

  val with3 = with2.add(3)
  println(with3.toString)

}
