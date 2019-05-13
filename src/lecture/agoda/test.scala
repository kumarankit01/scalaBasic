package lecture.agoda

import scala.io.StdIn

object Solution3 {

  def solve(n: Int, paintingRounds: Seq[(Int, Int, String)], initColor: String, queries: Seq[Int]): Seq[String] = {
    var temp: Array[String] = Array.fill(n) {
      ""
    }

    for (i <- paintingRounds.size - 1 to 0 by -1) {
      val x: (Int, Int, String) = paintingRounds(i)
      for (j <- x._1 - 1 to x._2 - 1) {
        if (temp(j) == "") temp(j) = x._3
      }
    }
    queries.map(i => {
      if (temp(i - 1) == "")
        println(initColor)
      else
        println(temp(i - 1))
    })


    Seq()
  }

  def main(args: Array[String]) {
    val line1 = StdIn.readLine.trim.split(" ")
    val n = line1(0).toInt
    val initColor = line1(1)
    val m = StdIn.readLine.trim.toInt
    val paintings = for {
      _ <- 1 to m
      linek = StdIn.readLine.trim.split(" ")
    } yield (linek(0).toInt, linek(1).toInt, linek(2))
    val q = StdIn.readLine.trim.toInt
    val queries = for {
      _ <- 1 to q
      query = StdIn.readLine.trim.toInt
    } yield query
    val result = solve(n, paintings, initColor, queries)
    result.foreach(println)
  }

}
