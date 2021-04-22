

console.log("running the js");

$("#num").load("/count")

$("#button").click(function () {
    console.log("button pushed!")
    $("#num").load("/increment")
})

const buttonIn = document.getElementById("websocket_button");

const socketRoute = document.getElementById("ws-route").value;
const socket = new WebSocket(socketRoute.replace("http","ws"));

init()

buttonIn.onclick = (event) => {
    socket.send("click");
    init()
}

socket.onmessage = (event) => {
    console.log("We incremented!");
}

