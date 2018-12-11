package pl.psych.graphs4s

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
import pl.psych.graphs4s.EdgeActor.{CheckConnection, EdgeActor}

object EdgeActor {
  def props[T](u: T, v: T): Props = Props(new EdgeActor(u, v))

  final case class CheckConnection[T](x: T)


case class EdgeActor[T](u: T, v: T) extends Actor {
  override def receive: Receive = {
    case CheckConnection(x) => sender() ! (u == x || v == x)
  }
}
}

class SupervisorActor extends Actor {
  override def receive: Receive = Actor.emptyBehavior
}

object SupervisorActor {
  def props(): Props = Props(new SupervisorActor)
}

case class ActorGraph[T](edges: Seq[ActorRef])(implicit actorSys: ActorSystem) {
  val supActor = actorSys.actorOf(SupervisorActor.props())

  def isConnected(x: T) = edges.map(e => e.tell(CheckConnection(x), supActor))
  supActor.ex
}

object ActorGraph {
  def apply[T](edges: Seq[(T, T)], name: String)(implicit actorSys: ActorSystem): ActorGraph[T] = {
    val edgeActors = edges.map(e => actorSys.actorOf(EdgeActor.props(e._1, e._2)))
    ActorGraph[T](edgeActors)
  }
}




object ActorGraphApp extends App {
  implicit val system = ActorSystem("testSystem")

  val es = Seq((1, 2), (2, 3), (4, 5), (6, 7))
  val g = ActorGraph[Int](es, "dupa")

  println(g.isConnected(1))

}
