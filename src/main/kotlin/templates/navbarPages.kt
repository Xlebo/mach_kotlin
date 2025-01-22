package com.mach.templates

import kotlinx.html.*

fun DIV.homeDiv() {
    h1("text-2xl font-bold") { +"Welcome to the Kotlin Web App" }
    p("mt-4") { +"Explore the Home, Users, and About pages using the navbar above." }
}

fun HTML.home() {
    body {
        div {
            homeDiv()
        }
    }
}

fun HTML.usersPage() {
    body {
        div {
            h1("text-2xl font-bold") { +"Users Page" }
            p("mt-4") { +"This is the users page." }
        }
    }
}

fun HTML.aboutPage() {
    body {
        div {
            h1("text-2xl font-bold") { +"About Page" }
            p("mt-4") { +"This is the about page." }
        }
    }
}

fun HTML.loginPage() {
    body {
        div {
            h1("text-2xl font-bold") { +"Login Page" }
            form(action = "/login", method = FormMethod.post, classes = "mt-4 space-y-4") {
                div {
                    label("block text-sm font-medium text-gray-700") { +"Username:" }
                    input(type = InputType.text, name = "username", classes = "mt-1 block w-full rounded-md border-gray-300 shadow-sm") {}
                }
                div {
                    label("block text-sm font-medium text-gray-700") { +"Password:" }
                    input(type = InputType.password, name = "password", classes = "mt-1 block w-full rounded-md border-gray-300 shadow-sm") {}
                }
                button(type = ButtonType.submit, classes = "bg-blue-600 text-white px-4 py-2 rounded") { +"Log In" }
            }
        }
    }
}