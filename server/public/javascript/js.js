

console.log("running the js");

$("#num").load("/count")

$("#button").click(function () {
    console.log("button pushed!")
    $("#num").load("/increment")
})