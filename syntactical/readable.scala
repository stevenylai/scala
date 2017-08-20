trait Readable {
  def read(buffer: CharBuffer): Int
}

trait AutoCloseable {
  def close(): Unit
}

class FileReader(file: File) extends Readable with AutoCloseable{
  def close(): Unit = ???
}
