package shared

import play.api.libs.json.Json

object ReadsAndWrites {
    case class OneMessage(msg:String, from:String)
    implicit val oneMessageReads = Json.reads[OneMessage]
    implicit val oneMessageWrites = Json.writes[OneMessage]
}