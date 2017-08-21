class Directory {
  private val numbers = scala.collection.mutable.Map(
    "Athos"           -> "7834 23456",
    "Steven"          -> "7834 23456"
  )
  def apply(name: String) = {
    numbers.get(name)
  }
  def update(name: String, number: String) = numbers.update(name, number)

  def update(areaCode: Int, newAreaCode: String) = numbers.foreach(entry => {
    if (entry._2.startsWith(areaCode.toString))
      numbers(entry._1) = entry._2.replace(areaCode.toString, newAreaCode)
  })
}
object Directory {
  def main(args: Array[String]) {
    val yellowPages = new Directory()
    println("Athos' telephone number : " + yellowPages("Athos"))
    yellowPages("Athos") = "7834 12345"
    println("Athos' new telephone number : " + yellowPages("Athos"))
    yellowPages(7834) = "7934"
    println("Athos' updated telephone number : " + yellowPages("Athos"))
  }
}
