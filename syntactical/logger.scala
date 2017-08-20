object Logger {
  def log(level: Level, string: String) {
    printf("%s %s%n", level, string)
  }

  def main(args: Array[String]) {
    Logger.log(Level.INFO, "Scala version")
  }
}
