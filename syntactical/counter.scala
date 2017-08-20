trait Counter {
  protected var count: Int
  def increment()
}

class IncrementByOne extends Counter {
  override var count = 1
  override def increment() : Unit = count += 1
}

class ExponentialIncrementer(rate: Int) extends Counter {
  override var count = 0
  override def increment() : Unit =
    if (count == 0)
      count = 1
    else
      count *= rate
}
