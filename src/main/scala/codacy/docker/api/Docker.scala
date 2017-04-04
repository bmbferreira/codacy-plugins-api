package codacy.docker.api

case class Docker(name: Docker.Image.Name, version: Docker.Image.Version) {
  val value: String = s"$name:$version"

  override def toString: String = value
}

object Docker {

  object Image {

    case class Name(value: String) extends AnyVal {
      override def toString: String = value
    }

    case class Version(value: String) extends AnyVal {
      override def toString: String = value
    }

  }

}
