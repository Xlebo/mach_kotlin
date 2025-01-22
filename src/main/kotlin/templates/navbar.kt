package com.mach.templates

import kotlinx.html.*

fun BODY.navbar(isLoggedIn: Boolean = false, username: String? = null) {
    nav("bg-blue-600 text-white px-6 py-4 flex justify-between items-center") {
        div("flex space-x-4") {
            a {
                href = "/home"
                classes = setOf("hover:bg-blue-700", "px-3", "py-2", "rounded")

                attributes["hx-get"] = "/home"
                attributes["hx-target"] = "#main-content"
                attributes["hx-swap"] = "innerHTML"

                +"Home"
            }
            a {
                href = "/users"
                classes = setOf("hover:bg-blue-700", "px-3", "py-2", "rounded")

                attributes["hx-get"] = "/users"
                attributes["hx-target"] = "#main-content"
                attributes["hx-swap"] = "innerHTML"

                +"Users"
            }
            a {
                href = "/about"
                classes = setOf("hover:bg-blue-700", "px-3", "py-2", "rounded")

                attributes["hx-get"] = "/about"
                attributes["hx-target"] = "#main-content"
                attributes["hx-swap"] = "innerHTML"

                +"About"
            }
        }
        if (isLoggedIn && username != null) {
            div("flex items-center space-x-4") {
                span { +"Logged in user: $username" }
                button(classes = "bg-red-500 text-white px-4 py-2 rounded") {

                    attributes["hx-post"] = "/logout"
                    attributes["hx-target"] = "body"
                    attributes["hx-swap"] = "outerHTML"

                    +"Log Out"
                }
            }
        } else {
            a {
                href = "/login"
                classes = setOf("bg-white", "text-blue-600", "px-4", "py-2", "rounded")

                attributes["hx-get"] = "/login"
                attributes["hx-target"] = "#main-content"
                attributes["hx-swap"] = "innerHTML"

                +"Login"
            }
        }
    }
}