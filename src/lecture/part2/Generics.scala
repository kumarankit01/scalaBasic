package lecture.part2

object Generics extends App {

  class MyList[A]{

  }

  //variance
  class Animal

  class Dog extends Animal

  class Cat extends Animal

  //if cat extends animal then does list of cat extends list of animal ??

  //yes : COVARIANCE
  class CovariantList[+A]{
    def add[A](ele : A) = ???
  }

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
 // val animalList2: CovariantList[Cat] = new CovariantList[Animal]


  //INVARIANCE

  class InvariantList[A]


  val ann: Animal = new Cat
  //val annList: InvariantList[Animal] = new InvariantList[Cat]

  //CONTRAVARIANT

  class contravariant[-A]

  val conAnn: Animal = new Cat
  //val annList: contravariant[Animal] = new contravariant[Cat]
  val conList: contravariant[Cat] = new contravariant[Animal]

  //bounded
  class Car
  class BoundedType1[A <: Animal](onlySubOfAnimal: A)
  new BoundedType1[Cat](new Cat)
  //new BoundedType1[Car](new Car)


  class BoundedType2[+A](anySubOfA: A)
  new BoundedType2[Car](new Car)


}
