package lecture.part2

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

object Exception extends App {

  def SOException: Int = 1 + SOException

  // SOException

  def OOMException {
    var st = new ListBuffer[A]()
    var count: Long = 0
    while (true) {
      count = count + 1
      println("here" + (count))
      st += A("qwewasdbKAJSHFHGLHJAGHIJHA;EKJRG;AEHIURHCF AWIEJFOIH3 WI[ERU[8Q23UR4]234809  2]-0R9 Q3U4URWIOEAJF ;NKGQ[3094RC2 ]3UR239I-RI  9238R Q32984-028")
    }

  }

  //
  // OOMException

  val x = Array.ofDim(Int.MaxValue)
// println( cal(2147483647,3).add)

}
case class A(string: String)


case class cal(x: Long, y: Long){
  def add = {
    val sum = x + y
    if(sum > Int.MaxValue) throw new OverflowException
    sum.toInt
  }

  def sub: Int = {
    val sub = x - y
    if(sub < Int.MinValue) throw new underFlowException
    sub.toInt
  }

  def devive = {
    if (y == 0 )
      throw new devideByZero
    (x/y).toInt
  }

  class OverflowException extends Exception

  class underFlowException extends Exception

  class devideByZero extends Exception

}

