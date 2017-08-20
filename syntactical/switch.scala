object Switch {
  def main(args: Array[String]) {
    val month = "August"
    val quarter = month match {
      case "January" | "February" | "March" => "1st quarter"
      case "April" | "May" | "June" => "2nd quarter"
      case "July" | "August" | "September" => "3rd quarter"
      case "October"  | "November" | "December" => "4th quarter"
      case _ => "unknown quarter"
    }
    println(month + " is the " + quarter)
  }
}
