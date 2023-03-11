package com.alphaomardiallo.webapp

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

const val ABOUT = "/about"

fun Route.about(){
    get(ABOUT){
        call.respondText("About page")
    }
}