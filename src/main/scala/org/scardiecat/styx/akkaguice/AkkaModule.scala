package org.scardiecat.styx.akkaguice
import akka.actor.ActorSystem
import com.google.inject.{Inject, Injector, Provider, AbstractModule}
import com.typesafe.config.Config
import org.scardiecat.styx.akkaguice.AkkaModule.ActorSystemProvider
import net.codingwell.scalaguice.ScalaModule

object AkkaModule {
  class ActorSystemProvider @Inject() (val config: Config, val injector: Injector) extends Provider[ActorSystem] {
    override def get() = {
      val actorSystemName = config.getString("styx.actor-system-name")
      val system = ActorSystem(actorSystemName, config)
      // add the GuiceAkkaExtension to the system, and initialize it with the Guice injector
      GuiceAkkaExtension(system).initialize(injector)
      system
    }
  }
}

/**
  * A module providing an Akka ActorSystem.
  */
class AkkaModule extends AbstractModule with ScalaModule {

  override def configure() {
    bind[ActorSystem].toProvider[ActorSystemProvider].asEagerSingleton()
  }
}