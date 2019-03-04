package lecture.part4

import scala.util.Random

object Sequences extends App {

  val seq = Seq(1, 1, 2)
  println(seq)

  val range: Seq[Int] = 1 to 10

  val apple = List.fill(5)("apples")
  println(apple)

  println("orange" +: apple :+ "banana")

  val x: Array[Int] = Array(1, 2, 3, 4, 5)
  println(x.mkString("-"))

  val numSeq: Seq[Int] = x

  println(numSeq)

  val maxRun = 1000
  val maxCapacity = 1000000

  def getWriteTime(col: Seq[Int]): Double = {

    val r = new Random
    val x: Seq[Long] = for {
      _ <- 1 to maxRun
    } yield {
      val currentTime = System.nanoTime()
      //col.updated(r.nextInt(maxCapacity), r.nextInt)
      System.nanoTime() - currentTime
    }
    (x.sum * 1.0) / maxRun
  }

  val vex = (1 to maxCapacity).toVector
  val sec = (1 to maxCapacity)
  val list = (1 to maxCapacity).toList

  println("list = "+ getWriteTime(list) )
  println("seq = "+ getWriteTime(sec) )
  println("vex = "+ getWriteTime(vex) )
}
