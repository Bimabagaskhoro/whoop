package com.whoop.app.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform