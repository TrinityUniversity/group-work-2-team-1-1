package models

import shared.ReadsAndWrites._

object OneMessageModel {

    private var currentMessage = OneMessage("hello", "dane")
    def setMessage(m: OneMessage):String = {
        val ret = currentMessage
        currentMessage = m
        //send the message below this comment?
        ret.msg
    }
}