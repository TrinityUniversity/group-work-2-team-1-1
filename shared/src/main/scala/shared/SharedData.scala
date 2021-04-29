package shared

import play.api.libs.json.Json

case class OneMessage(msg:String, author:String)

object ReadsAndWrites {
    implicit val oneMessageReads = Json.reads[OneMessage]
    implicit val oneMessageWrites = Json.writes[OneMessage]
}