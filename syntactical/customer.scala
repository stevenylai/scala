class User(forename: String, initial: String = "", surname: String) {
  val fullname = if (initial != null && !initial.isEmpty)
                   forename + " " + initial + ". " + surname
                 else
                   forename + " " + surname
  private var seq = User.nextSequence()
}

object User {
  private var sequence = 0

  private def nextSequence() = {
    sequence += 1
    sequence
  }
}

class Item(val price: Double) {
}
class ShoppingBasket {
  var value = 0.0
  def add(item: Item) = {
    value += item.price
  }
}

class Customer(val name: String, val address: String)
extends Ordered[Customer] {
  private var _id = ""
  def id = _id
  def id_=(value: String) {
    if (_id.isEmpty)
      _id = value
  }

  private final val basket: ShoppingBasket = new ShoppingBasket
  def add(item: Item) = {
    basket.add(item)
  }

  def total: Double =
    basket.value

  def compare(that: Customer): Int =
    name.compare(that.name)

  override def toString: String = name + " $ " + total
}

class DiscountedCustomer(name: String, address: String)
extends Customer(name, address) {
  override def total: Double = {
    super.total * 0.9
  }
}

class Customers extends Sortable[Customer] {
  private val customers = mutable.Set[Customer]()

  def add(customer: Customer) = customers.add(customer)
  def iterator: Iterator[Customer] = customers.iterator
}
object Customer {
  def apply(name: String, address: String) = new Customer(name, address)

  def main(args: Array[String]) {
    val eric = new Customer("Eric", "29 Acacia Road")
    eric.id = "0002"
    eric.id_=("0001")
    val bob = new User("Bob", surname = "Smith")
    val joe = new DiscountedCustomer("Joe", "128")
    joe.add(new Item(2.5))
    joe.add(new Item(3.5))
    println("Joe's basket will cost $" + joe.total)
    val customers = new Customers()
    customers.add(new Customer("Steven", "1st"))
    customers.add(new DiscountedCustomer("Sally", "2nd"))
    println(customers.sort)
  }
}
