import java.io.PrintWriter

object Solution {

  // Complete the solve function below.
  def solve(coordinates: Array[Array[Int]]): String = {
    var max_x = Int.MinValue
    var max_y = Int.MinValue
    var min_x = Int.MaxValue
    var min_y = Int.MaxValue


    for (i <- 0 until coordinates.length) {
      if (max_x < coordinates(i)(0))
        max_x = coordinates(i)(0)
       if (min_x > coordinates(i)(0))
        min_x = coordinates(i)(0)

      if (min_y > coordinates(i)(1))
        min_y = coordinates(i)(1)
      if (max_y < coordinates(i)(1))
        max_y = coordinates(i)(1)
    }

    println(max_x + " " + max_y + " " + min_x + " " + min_y)
    var boolean = true
    for (i <- 0 until coordinates.length) {
      val x = coordinates(i)(0)
      val y = coordinates(i)(1)


      if ((x == min_x || x == max_x) && (min_y <= y && y <= max_y)) {

      } else if ((y == min_y || y == max_y) && (min_x <= x && x <= max_x)) {

      } else {
        boolean = false
      }
    }
  if(boolean)
    "YES"
    else
    "NO"

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    // val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val n = stdin.readLine.trim.toInt

      val coordinates = Array.ofDim[Int](n, 2)

      for (i <- 0 until n) {
        coordinates(i) = stdin.readLine.split(" ").map(_.trim.toInt)
      }

      val result = solve(coordinates)

      // printWriter.println(result)
    }

    //printWriter.close()
  }
}
