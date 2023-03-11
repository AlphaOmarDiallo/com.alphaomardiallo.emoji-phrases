package com.alphaomardiallo.plugins

import com.alphaomardiallo.webapp.about
import com.alphaomardiallo.webapp.home
import io.ktor.server.routing.*
import io.ktor.server.application.*

/**
 * Routing of the web application
 *
 * All the routing for the web application goes through this plugin.
 */
fun Application.configureRouting() {
    routing {
        //Home page
        home()
        // About page
        about()
    }
}
