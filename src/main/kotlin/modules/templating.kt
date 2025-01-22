package com.mach.modules

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.css.*

fun Application.configureTemplating() {
    routing {
        staticResources("styles.css", "/")

        get("/styles.css") {
            call.respondCss {
                body {
                    backgroundColor = Color.lightGray
                    margin(0.px)
                }
                rule("h1.page-title") {
                    color = Color.white
                }
            }
        }
    }
}

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
   this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}
