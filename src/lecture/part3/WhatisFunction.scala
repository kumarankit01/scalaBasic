package lecture.part3

object WhatisFunction extends App {

  val contactinator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(contactinator("abc", "def"))

  val func = new Function[Int, Int] {
    override def apply(v2: Int): Int = v2
  }

  val funcWrapper = new Function[Int, Function1[Int, Int]] {
    override def apply(v4: Int): Int => Int = func
  }

  val x: Int => Int = funcWrapper(1)

  println(x)

  val y: Int = funcWrapper(1)(1)

  println(y)
}
