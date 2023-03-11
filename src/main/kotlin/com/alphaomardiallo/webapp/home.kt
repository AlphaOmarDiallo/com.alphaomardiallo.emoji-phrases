package com.alphaomardiallo.webapp

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

const val HOME = "/"

fun Route.home(){
    get(HOME){
        call.respondText("Home")
    }
}