package com.hari.beatly

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform