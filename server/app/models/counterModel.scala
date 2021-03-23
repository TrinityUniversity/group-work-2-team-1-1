package models

import java.util.concurrent.atomic.AtomicInteger

object counterModel {
    private val count = new AtomicInteger(0)
    def increment = count.getAndIncrement()
    def getCount = count.get()
}