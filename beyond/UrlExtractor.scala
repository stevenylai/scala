object UrlExtractor {
  def unapply(string: String): Option[(String, string)] = {
    try {
      val url = new URL(string)
      Some((url.getProtocol, url.getHost))
    } catch {
      case _: Throwable => None
    }
  }
  def main(args: Array[String]) = {
    val url = "http://baddotrobot.com" match {
      case UrlExtractor(protocol, host) => println(protocol + " " + host)
    }
  }
}
