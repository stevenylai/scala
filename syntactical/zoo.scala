class Animal extends Comparable[Animal] {
  def compareTo(o: Animal): Int = 0
}
class Lion extends Animal
class Zebra extends Animal

object Animal {
  def sort[A <: Comparable[U], U >: A](list: List[A]) = {}

  def main(args: String*) {
    var enclosure = List[Lion]()
    enclosure = new Lion +: enclosure
    enclosure = new Lion +: enclosure
    sort[Lion, Animal](enclosure)

    var zoo = List[Animal]()
    zoo = new Zebra +: zoo
    zoo = new Lion +: zoo
    sort(zoo)
  }
}
