package com.mach.templates

import kotlinx.html.*

fun HTML.index(username: String?) {
    lang = "en"
    head {
        meta { charset = "UTF-8" }

        meta {
            name = "viewport"
            content = "width=device-width, initial-scale=1.0"
        }

        title("mach_kotlin")

        link {
            type = "text/css"
            rel = "stylesheet"
            href = "styles.css"
        }

        script {
            type = "application/javascript"
            src = "composeApp.js"
        }

        script {
            src = "https://unpkg.com/htmx.org@2.0.4"
            integrity = "sha384-HGfztofotfshcF7+8n44JQL2oJmowVChPTg48S+jvZoztPfvwD79OC/LTtG6dMp+"
            crossorigin = ScriptCrossorigin.anonymous
        }

        link(rel = "stylesheet", href = "https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css")

    }
    body {
        classes = setOf("bg-gray-100")
        navbar(username != null, username)
        div("container mx-auto p-6") {
            id = "main-content"
            homeDiv()
        }
    }
}
