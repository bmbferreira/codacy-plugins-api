package codacy.docker.api

case class URL(value: String) extends AnyVal {
  override def toString: String = value
}
