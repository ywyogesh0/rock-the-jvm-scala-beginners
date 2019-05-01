package playground

object SelfTypeReference extends App {

  val abc = Name("Yogesh")

  println(abc.getFullName)
  println(abc.getFirstName)
  println(abc.getLastName)
}

class Name(firstName: String) {
  self: LastName =>
  def getFullName: String = s"$firstName ${self.getLastName}"

  def getFirstName: String = s"$firstName"
}

object Name {
  def apply(firstName: String) = new Name(firstName) with LastName
}

trait LastName extends GenericName[String] {
  override def getLastName: String = "Walia"
}

trait GenericName[A] {
  def getLastName: A
}