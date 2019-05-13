package lecture.part4

object MapAndTuples extends App {

  val map = Map("Jim" -> 555, "JIM" -> 4545)
  println(map)

  val newMap: Map[String, Int] = map.map(x => x._1.toLowerCase -> x._2)

  println(newMap)

  class social {

    def add(network: Map[String, Seq[String]] = Map(), string: String) = network + (string -> Seq())

    def remove(network: Map[String, Seq[String]], string: String) = {
      def unFrnd(s: Seq[String], network: Map[String, Seq[String]]): Map[String, Seq[String]] = {
        if (s.isEmpty)
          network
        else {
          println("unfrnd" + string + " & " + s.head)
          unFrnd(s.tail, unFriend(network, string, s.head))
        }
      }

      val net = unFrnd(network(string), network)

      net - string
    }

    def friend(network: Map[String, Seq[String]], a: String, b: String) = {
      val temp: Map[String, Seq[String]] = network + (a -> (network.get(a).map(x => x :+ b)).getOrElse(Seq(b)))
      val finalMap = temp + (b -> (temp.get(b).map(x => x :+ a)).getOrElse(Seq(a)))
      finalMap
    }

    def unFriend(network: Map[String, Seq[String]], friendA: String, friendB: String) = {
      val friendsOfA: Seq[String] = network(friendA)
      val friendsOfB: Seq[String] = network(friendB)
      network + (friendA -> (friendsOfA diff Seq(friendB))) + (friendB -> (friendsOfB diff  Seq(friendA)))
    }

    def singles(network: Map[String, Seq[String]]) = network.count(_._2.isEmpty)

    def maxFriend(network: Map[String, Seq[String]]) = network.flatMap(x => network.filter(y => y._2.size > x._2.size))
  }


  val sn = new social
  val step1 = sn.add(sn.add(sn.add(string = "c"), string = "a"), string = "b")
  println(step1)

  val step2 = sn.friend(step1, "a", "b")

  println(step2)

  println(sn.singles(step2))

  println(sn.maxFriend(step2))

  val step3 = sn.friend(step2, "a", "c")

  println(step3)

  val step4 = sn.remove(step3, "a")

  println(step4)


}
