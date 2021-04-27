package models

import shared.ReadsAndWrites._

object OneMessageModel {
    private var currentMessage = OneMessage("hello", "dane")

    def storeMessage(m: OneMessage):OneMessage = {
        val tmp = currentMessage
        currentMessage = m
        tmp
    }
}