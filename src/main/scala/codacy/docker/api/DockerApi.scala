package codacy.docker.api

sealed trait Source extends Any {
  def path: String

  override def toString: String = path
}

object Source {

  case class Directory(path: String) extends AnyVal with Source

  case class File(path: String) extends AnyVal with Source

  case class Line(value: Int) extends AnyVal {
    override def toString: String = value.toString
  }

}

case class ErrorMessage(value: String) extends AnyVal {
  override def toString: String = value
}

case class Configuration(tools: Set[Engine.Configuration], files: Option[Set[Source.File]],
                         options: Option[Map[Configuration.Key, Configuration.Value]])

object Configuration {

  case class Key(value: String) extends AnyVal

  // JsonEncoded!
  // case class Value(value:Any) extends AnyVal
  trait Value extends Any

}

case class AlternativeConfiguration(enabled: Boolean, include_paths: Option[Set[Source.File]])
