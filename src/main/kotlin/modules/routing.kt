package com.mach.modules

import com.mach.templates.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        var loggedInUser: String? = null

        get("/") {
            call.respondHtml(HttpStatusCode.OK) {
                index(loggedInUser)
            }
        }

        get("/home") {
            call.respondHtml(HttpStatusCode.OK) {
                home()
            }
        }

        get("/users") {
            call.respondHtml(HttpStatusCode.OK) {
                usersPage()
            }
        }

        get("/about") {
            call.respondHtml(HttpStatusCode.OK) {
                aboutPage()
            }
        }

        get("/login") {
            call.respondHtml(HttpStatusCode.OK) {
                loginPage()
            }
        }

        post("/login") {
            val params = call.receiveParameters()
            val username = params["username"]
            val password = params["password"]

            // Simplified login logic for demonstration purposes
            if (username != null && password == "password") {
                loggedInUser = username
                call.respondRedirect("/")
            } else {
                call.respondHtml(HttpStatusCode.Forbidden) {
                    loginPage()
                }
            }
        }

        post("/logout") {
            loggedInUser = null
            call.respondRedirect("/")
        }
    }
}