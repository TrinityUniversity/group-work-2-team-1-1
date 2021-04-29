package controllers

import javax.inject._

import play.api.mvc._
import play.api.i18n._
import play.api.libs.json._
import models._
import scala.concurrent.Future
import shared.OneMessage
import shared.ReadsAndWrites._

@Singleton
class MessageController @Inject() (cc: ControllerComponents) extends AbstractController(cc) { 
    var storedMessage = OneMessage("First Message", "First Author")

    def load = Action { implicit request =>
        Ok(views.html.oneMessager())
    }

    def withJsonBody[A](f: A => Result)(implicit request: Request[AnyContent], reads: Reads[A]): Result = {
        request.body.asJson.map { body =>
            Json.fromJson[A](body) match {
                case JsSuccess(a, path) => f(a)
                case e @ JsError(_) => Redirect(routes.MessageController.load())
            }
        }.getOrElse(Redirect(routes.MessageController.load()))
    }

    def addMessage = Action { implicit request => 
        withJsonBody[OneMessage] { message =>
            storedMessage = message
            Ok(Json.toJson(true))
        }
    }
}