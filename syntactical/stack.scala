trait Stack[T] {
  def push(t: T)
  def pop: T
}

class ListStack[T] extends Stack[T] {
  private var elements: List[T] = List()

  override def push(t: T): Unit = elements = t +: elements

  override def pop: T = {
    if (elements.isEmpty)
      throw new IndexOutOfBoundsException
    val head = elements.head
    elements = elements.tail
    head
  }
}

object Stack {
  def main(args: String*) {
    val stack = new ListStack[String]
    stack.push("C")
    stack.push("B")
    stack.push("A")
    val elemen = stack.pop
  }
}
