package codacy.docker.api

case class Language(name: String) extends AnyVal {
  override def toString: String = name
}
