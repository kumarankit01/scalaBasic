package lecture.agoda

import java.io.PrintWriter

import scala.annotation.tailrec

object Solution {

  // Complete the solve function below.
  def solve(a: Int, b: Int, t: Long): Int = {
    val init = (a * 0.5 * 1 + b * 0.5 * 1).toInt

    @tailrec
    def cell(a: Int, b: Int, t: Long, acc: Int = init): Int = {
      val M = 1000000007
      if (t == 1)
        acc
      else {
        val a1 = (a * 0.5 * acc) % M
        val b1 = (b * 0.5 * acc) % M
        val newVal = (a1 + b1) % M
        cell(a, b, t - 1, acc + newVal.toInt)
      }

    }

    cell(a, b, t)

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val abt = stdin.readLine.split(" ")

    val a = abt(0).trim.toInt

    val b = abt(1).trim.toInt

    val t = abt(2).trim.toLong

    val result = solve(a, b, t)
    println(result)

  }
}