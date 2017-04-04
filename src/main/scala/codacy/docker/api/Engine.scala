package codacy.docker.api

import scala.util.Try

trait EngineImpl {
  def apply(source: Source.Directory,
            configuration: Option[List[Pattern.Definition]],
            files: Option[Set[Source.File]],
            options: Map[Configuration.Key, Configuration.Value])
           (implicit specification: Engine.Specification): Try[List[Result]]
}

case class Engine(base: EngineBase, docker: Docker, spec: Option[Engine.Specification], description: Option[Set[Pattern.Description]])

case class EngineBase(id: Engine.Id,
                      name: Engine.Name,
                      slug: Engine.Slug,
                      documentationUrl: URL,
                      sourceCodeUrl: URL,
                      description: Engine.Description,
                      languages: Set[Language],
                      channels: Engine.Channels,
                      configFileNames: Set[Source.File],
                      hasUIConfiguration: Boolean,
                      needsPatternsToRun: Boolean,
                      needsCompilation: Boolean)

object Engine {

  case class Name(value: String) extends AnyVal {
    override def toString: String = value
  }

  case class Description(value: String) extends AnyVal {
    override def toString: String = value
  }

  case class Slug(value: String) extends AnyVal {
    override def toString: String = value
  }

  case class Id(value: String) extends AnyVal {
    override def toString: String = value
  }

  case class Configuration(name: Engine.Name, patterns: Option[List[Pattern.Definition]])

  case class Specification(name: Engine.Name, patterns: Set[Pattern.Specification])

  case class Channel(name: Engine.Channel.Name, version: Docker.Image.Version)

  object Channel {

    case class Name(value: String) extends AnyVal

  }

  case class Channels(stable: Channel, all: Set[Channel])

}
