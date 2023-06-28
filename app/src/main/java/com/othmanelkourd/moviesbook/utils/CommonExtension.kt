package com.othmanelkourd.moviesbook.utils


import kotlin.time.Duration.Companion.minutes


fun Int.toDuration(): String {
    return "${this.minutes.inWholeHours}h ${this % 60}m"
}