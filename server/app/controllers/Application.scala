package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._

import models.counterModel

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def index = Action {
    Ok("")
  }

  def mainPage = Action { implicit request =>
    Ok(views.html.counter())
  }

  def getCount = Action { implicit request =>
    Ok(counterModel.getCount.toString)
  }

   def count = Action { implicit request =>
     counterModel.increment
     Ok(counterModel.getCount.toString)
   }   
  
}