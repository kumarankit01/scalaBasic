package lecture


import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object MultipleFutures1 extends App {

  // (a) create the futures
  val f1 = Future { sleep(400); 1 }
  val f2 = Future { sleep(200); 2 }
  val f3 = Future { sleep(400); 3 }

  // (b) run them simultaneously in a for-comprehension
  val s = System.currentTimeMillis()
  val result = for {
    r1 <- f1
    r2 <- f2
    r3 <- f3
  } yield (r1 + r2 + r3)

  // (c) do whatever you need to do with the result
  result.onComplete {
    case Success(x) => println(s"\nresult = $x  | total = ${System.currentTimeMillis() - s}")
    case Failure(e) => e.printStackTrace
  }
  val f = Future(println("hello"))
  Future.sequence(List(f, f, f, f))
  // important for a little parallel demo: keep the jvm alive
  sleep(3000)

  def sleep(time: Long): Unit = Thread.sleep(time)

}