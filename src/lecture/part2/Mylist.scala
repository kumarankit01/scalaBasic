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

  def Map[B](transformer: A => B): Mylist[B]

  def filter(myPredicate: A => Boolean): Mylist[A]

  def flatMap[B](transformer: A => Mylist[B]): Mylist[B]

  //concatenation
  def ++[B >: A](list: Mylist[B]): Mylist[B]

  //hofs
  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): Mylist[A]

  def zipWith[B, C](list: Mylist[B], zip: (A, B) => C): Mylist[C]

  def fold[B](start: B)(f: (A, B) => B): B
}

case class Node[+A](val value: A, val next: Mylist[A] = Empty) extends Mylist[A] {
  override def head: A = value

  override def tail: Mylist[A] = next

  override def isEmpty: Boolean = false

  override def add[B >: A](value: B): Mylist[B] = new Node[B](value, this)

  override def zipWith[B, C](list: Mylist[B], zip: (A, B) => C): Mylist[C] = {
    if (list.isEmpty) throw new RuntimeException("list is not of same size")
    else new Node[C](zip(head, list.head), tail.zipWith(list.tail, zip))
  }


  override def Map[B](transformer: A => B): Mylist[B] = {
    new Node[B](transformer(value), next.Map(transformer))
  }

  override def filter(myPredicate: A => Boolean): Mylist[A] = {
    if (myPredicate(value)) {
      new Node[A](value, next.filter(myPredicate))
    } else {
      next.filter(myPredicate)
    }
  }

  /*
   [ 1 , 2 , 3 ] ++ [4, 5]
   new node (1, [2,3 ] ++ [4,5])
   new node (1, new Node (2), [3] ++ [4,5]
   new node (1, new Node (2), new node (3 , empty ++ 4,5)
   new node (1, new Node (2), new node (3 , [4, 5, empty])
   */
  def ++[B >: A](list: Mylist[B]): Mylist[B] = {
    new Node[B](value, tail ++ (list))
  }

  override def flatMap[B](transformer: A => Mylist[B]): Mylist[B] = {
    transformer(value) ++ next.flatMap(transformer)
  }

  override def foreach(f: A => Unit): Unit = {
    f(head)
    tail.foreach(f)
  }

  override def sort(compare: (A, A) => Int): Mylist[A] = {

    def insert(a: A, value: Mylist[A]): Mylist[A] = {
      if (value.isEmpty) new Node(a, Empty)
      else if (compare(a, value.head) < 0) new Node(a, value)
      else new Node(value.head, insert(a, value.tail))
    }

    val sortedTail = tail.sort(compare)
    insert(head, sortedTail)
  }

  override def fold[B](start: B)(f: (A, B) => B): B = {
    tail.fold(f(head, start))(f)
  }
}

case object Empty extends Mylist[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: Mylist[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](value: B): Mylist[B] = new Node[B](value, Empty)

  override def Map[B](transformer: Nothing => B): Mylist[B] = Empty

  override def filter(myPredicate: Nothing => Boolean): Mylist[Nothing] = Empty

  override def flatMap[B](transformer: Nothing => Mylist[B]): Mylist[B] = Empty

  override def ++[B >: Nothing](list: Mylist[B]): Mylist[B] = list

  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(compare: (Nothing, Nothing) => Int): Mylist[Nothing] = Empty

  override def zipWith[B, C](list: Mylist[B], zip: (Nothing, B) => C): Mylist[Nothing] = {
    if (!list.isEmpty)
      throw new RuntimeException("list is not of same size")
    else
      Empty
  }

  override def fold[B](start: B)(f: (Nothing, B) => B): B = start
}


trait MyPredicate[-T] {
  def apply(t: T): Boolean
}


trait MyTransformer[-A, B] {
  def apply(a: A): B
}


object ListTest extends App {
  val list: Node[Int] = new Node(3)
  println(list.toString)
  val with2 = list.add(2)

  val with3 = with2.add(1)
  println(with3.toString)

  with3.foreach(println)

  println(with3.sort((x, y) => y - x))

  val listString = new Node[String]("alpa", new Node[String]("beta"))

  println(with2.zipWith[String, String](listString, _ + "-" + _))

  println(with3.fold(0)(_+_))

  /*  println(with3.filter(new MyPredicate[Int] {
      override def apply(t: Int): Boolean = t % 2 == 0
    }).toString)


    println(with3.Map(a => a * 2).toString)


    println((with3 ++ with3).toString)

    println(
      with3.flatMap(new MyTransformer[Int, Mylist[Int]] {
        override def apply(a: Int): Mylist[Int] = new Node[Int](a * 2, new Node[Int](a * 4))
      })
    )*/
}
