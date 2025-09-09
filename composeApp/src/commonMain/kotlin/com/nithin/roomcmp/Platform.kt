package com.nithin.roomcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform