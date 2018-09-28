import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.RunnableGraph

import scala.concurrent.{Await, Future}

import scala.concurrent.duration._

trait GraphExec {

  def await[A](f: Future[A]):A = Await.result(f, 1 second)

  def executeGraph[A](graph: RunnableGraph[Future[A]]): A = {
    val as = ActorSystem()
    val mat = ActorMaterializer()(as)
    val result = graph.run()(mat)
    as.terminate()
    await(result)
  }
}
