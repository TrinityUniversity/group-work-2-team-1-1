package controllers

import javax.inject._

import play.api.mvc._
import play.api.i18n._
import play.api.libs.json._
import akka.actor.Actor
import play.api.libs.streams.ActorFlow
import akka.actor.ActorSystem
import akka.stream.Materializer
import akka.actor.Props
import actors.ButtonActor

@Singleton
class WebSocketCount @Inject()(cc: ControllerComponents)(implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {
    def index = Action { implicit request => 
        Ok(views.html.wsocketcount())
    }

    def socket = WebSocket.accept[String, String] { request =>
        ActorFlow.actorRef { out =>
            ButtonActor.props(out)
        }
    }
}
