package lecture.part4

trait MaybeT[+T] {

  def map[B](f: T => B): MaybeT[B]

  def flatmap[B](f: T => MaybeT[B]): MaybeT[B]

  def filter(f: T => Boolean): MaybeT[T]
}

case class Maybe[+T](value: T) extends MaybeT[T] {

  override def toString: String = "" + value

  override def map[B](f: T => B): MaybeT[B] = Maybe(f(value))

  override def flatmap[B](f: T => MaybeT[B]): MaybeT[B] = f(value)

  override def filter(f: T => Boolean): MaybeT[T] = if (f(value)) this else Empty
}

case object Empty extends MaybeT[Nothing] {

  override def map[B](f: Nothing => B): MaybeT[B] = Empty

  override def flatmap[B](f: Nothing => MaybeT[B]): MaybeT[B] = Empty

  override def filter(f: Nothing => Boolean): MaybeT[Nothing] = Empty
}

object MaybeTest extends App {

  val x: Maybe[Int] = Maybe(3)
  val y = x.map(_ * 10 + 10).filter(_ > 100)
  println(y)

}