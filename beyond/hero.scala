class Person(val name: String)

case class SuperHero(heroName: String, alterEgo: String, powers: List[String])
extends Person(alterEgo)

object Example {
  def main(args: Array[String]) {
    val bruce = new SuperHero("Batman", "Bruce Wayne", List("Intellect", "Agility"))
    val steve = new SuperHero("Captain America", "Steve Rogers", List("Shield", "Strength"))
    val jayne = new Person("Jayne Doe")

    def superPowerFor(person: Person) = {
      person match {
        case SuperHero(_, _, powers) => powers
        case _ => List()
      }
    }
    println("Bruce has powers " + superPowerFor(bruce))
    println("Steve has powers " + superPowerFor(steve))
    println("Jayne has powers " + superPowerFor(jayne))

    def nameFor(person: Person) = {
      person match {
        case hero: SuperHero => hero.alterEgo
        case person: Person => person.name
      }
    }
    println("Bruce's alter ego is " + nameFor(bruce))
    println("Steve's alter ego is " + nameFor(steve))
    println("Jayne's alter ego is " + nameFor(jayne))

  }
}
