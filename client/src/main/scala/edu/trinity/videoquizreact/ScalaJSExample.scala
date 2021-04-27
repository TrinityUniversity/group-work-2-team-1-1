package edu.trinity.videoquizreact

import shared.SharedMessages
import org.scalajs.dom

import slinky.core._
import slinky.web.ReactDOM
import slinky.web.html._

import org.scalajs.dom
import org.scalajs.dom.document
import org.scalajs.dom.html
import org.scalajs.dom.experimental.Fetch
import org.scalajs.dom.experimental.Headers
import org.scalajs.dom.experimental.RequestInit
import org.scalajs.dom.experimental.HttpMethod
import org.scalajs.dom.experimental.RequestMode
import play.api.libs.json.Json

import scala.scalajs.js.Thenable.Implicits._
import play.api.libs.json.JsSuccess
import play.api.libs.json.JsError
import scala.concurrent.ExecutionContext
import scala.scalajs.js.annotation.JSExportTopLevel
import scalajs.js

object ScalaJSExample {
  def addClickedMessage():Unit = {
    println("button pressed!")
    val b = document.getElementById("specialBtn")
    val s = b.innerText
    val intS = s.toInt
    b.innerText = (intS + 1).toString()
  }
  def handleInput() {
    val message:String = document.getElementById("inputField").asInstanceOf[html.Input].value
    val author = document.getElementById("authorField").asInstanceOf[html.Input].value
    println(s"message: $message author: $author")
    PostFetch.
    
  }
  def main(args: Array[String]): Unit = {
    // dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    // println("1 2 3 4 5 6 7 8 9 10")
    // val b = document.createElement("button")
    // b.setAttribute("id", "specialBtn")
    // b.innerHTML = "0"
    // val content = document.getElementById("content")
    // content.appendChild(b)
    // b.addEventListener("click", { (e: dom.MouseEvent) => addClickedMessage() })

    val b = document.getElementById("button")
    b.addEventListener("click", {
      (e: dom.MouseEvent) => handleInput()
    })
    ReactDOM.render(
      h1("testing"),
      dom.document.getElementById("content")
    )


    

    
    // ReactDOM.render(
    //   h1("Hello, world!"),
    //   dom.document.getElementById("root")
    // )
  }

}


import org.scalajs.dom
import scala.concurrent.ExecutionContext
import org.scalajs.dom.experimental._
import play.api.libs.json._
import scala.scalajs.js.Thenable.Implicits._
import scala.scalajs.js.JSON

object PostFetch {
  implicit val ec = ExecutionContext.global
                //url: the route //oneMessage //success case //failure case
  def fetch[A, B](url: String, data: A, success: B => Unit, error: JsError => Unit)(implicit writes: Writes[A], reads: Reads[B]): Unit = {
    val hs = new Headers()
    hs.set("Content-Type", "application/json")
    hs.set("Csrf-Token", dom.document.getElementsByTagName("body").apply(0).getAttribute("data-token"))
    Fetch.fetch(
      url,
      new RequestInit {
        method = HttpMethod.POST
        headers = hs
        body = Json.toJson(data).toString
      }
    ).flatMap(_.text()).map { res =>
      Json.fromJson[B](Json.parse(res)) match {
        case JsSuccess(ret, path) => 
          success(ret)
        case e @ JsError(_) => 
          println("Fetch error " + e)
          error(e)
      }
    }
  }
}
