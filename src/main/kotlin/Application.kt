package com.mach

import com.mach.modules.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureTemplating()
    configureSecurity()
    configureRouting()
}
