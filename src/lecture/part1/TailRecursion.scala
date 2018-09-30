package lecture.part1

import scala.annotation.tailrec

object TailRecursion extends App {

  /*  def factorial(n: Int): Int = {
      if (n <= 1)
        1
      else {
        println(s"computing factorial of $n but first I need ${n - 1}")
        val result = n * factorial(n - 1)
        println(s"computed factorial of $n")
        result
      }
    }

    //factorial(20)

    def tailRecFct(n: Int): BigInt = {
      @tailrec
      def fact(n: Int, acc: BigInt): BigInt = {
        if (n <= 1) acc
        else {
          println(s"multiplying $n to $acc")
          fact(n - 1, n * acc)
        }
      }

      fact(n, 1)
    }

    println(tailRecFct(20))

    def concatString(s: String, n: Int): String = {

      @scala.annotation.tailrec
      def accu(s: String, n: Int, acc: String): String = {
        if (n == 0)
          acc
        else
          accu(s, n - 1, s + acc)
      }

      accu(s, n, "")
    }

    println(concatString("hello", 3))

    def isPrime(n: Int): Boolean = {
      @scala.annotation.tailrec
      def accu(n: Int, devisor: Int): Boolean = {
        println(s"$n % $devisor")
        if (devisor <= 1)
          true
        else if (n % devisor == 0)
          false
        else accu(n, devisor - 1)
      }

      accu(n, Math.sqrt(n).toInt)
    }

    println(isPrime(2003))*/

  // 1 1 2 3 5 8 13 21
  def tailRecFibo(n: Int): Int = {
    @tailrec
    def accu(n: Int, acc1: Int, acc2: Int): Int = {
      if (n == 2)
        acc1
      else {
        println(s"acc1 = $acc1 and acc2 = $acc2")
        accu(n - 1, acc1 + acc2, acc1)
      }
    }

    accu(n, 1, 1)
  }

  println(tailRecFibo(3))
}



