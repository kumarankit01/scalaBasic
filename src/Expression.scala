object Expression extends App {

  def factorial(n: Int): Int = {

    if (n <= 1)
      1
    else
      n * factorial(n - 1)

  }

  def fibbonacci(n: Int): Int = {
    if (n == 1 || n == 0)
      1
    else
      fibbonacci(n - 1) + fibbonacci(n - 2)
  }

  def isPrime(n: Int, i: Int = 2): Boolean = {

    def isPrimeUntil(t : Int): Boolean = {
      if(t <= 1)
        true
      else
        n % i != 0 && isPrimeUntil(t - 1)
    }
      isPrimeUntil(math.sqrt(n).toInt)
  }

  println(isPrime(13))
  println(fibbonacci(6))
  println(factorial(5))

}
