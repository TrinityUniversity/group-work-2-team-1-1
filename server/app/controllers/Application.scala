package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._
import scala.concurrent.Future


import models.counterModel
import play.api.libs.json._
import play.api.libs.json.JsSuccess
import play.api.libs.json.JsError
import play.api.libs.json.Reads

import shared.ReadsAndWrites._
import models.OneMessageModel

@Singleton
class Application @Inject() (cc: ControllerComponents)
    extends AbstractController(cc) {

    implicit val oneMessageReads = Json.reads[OneMessage]
    implicit val oneMessageWrites = Json.writes[OneMessage]   
  def index = Action {
    Ok("")
  }

  def mainPage = Action { implicit request =>
    Ok(views.html.oneMessager())
  }

  def getCount = Action { implicit request =>
    Ok(counterModel.getCount.toString)
  }

  def count = Action { implicit request =>
    counterModel.increment
    Ok(counterModel.getCount.toString)
  }
  def handleAJAX = Action { implicit request => ??? }

  def withJsonBody[A](
      f: A => Future[Result]
  )(implicit request: Request[AnyContent], reads: Reads[A]): Future[Result] = {
    request.body.asJson
      .map { body =>
        Json.fromJson[A](body) match {
          case JsSuccess(a, path) => f(a)
          case e @ JsError(_) =>
            Future.successful(Redirect(routes.Application.mainPage()))
        }
      }
      .getOrElse(Future.successful(Redirect(routes.Application.mainPage())))
  }

  def receiveMessage = Action.async { implicit request =>
    withJsonBody[OneMessage] { ud =>
      val om = OneMessageModel.storeMessage(ud)
      Future.successful(Ok(Json.toJson(om)))
    }
  }
}
