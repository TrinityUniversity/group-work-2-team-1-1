package actors

import akka.actor.ActorRef
import akka.actor.Actor
import akka.actor.Props

class ButtonActor(out: ActorRef) extends Actor {
    def receive = {
        case s: String => 
            println("Clicked")
            out ! "clicked"
        case m => println("Unhandled message in ButtonActor: " + m)
    }

    
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}

object ButtonActor {
    def props(out: ActorRef) = Props(new ButtonActor(out))
}