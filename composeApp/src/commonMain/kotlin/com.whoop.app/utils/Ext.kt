package com.whoop.app.utils

import com.whoop.app.feature.home.core.model.SwipeCard
import com.whoop.app.utils.UtilsConstant.RANDOM_STRING

fun stringFrom(direction: SwipeCard): String {
    return when (direction) {
        SwipeCard.LEFT -> "Left 👈"
        SwipeCard.RIGHT -> "Right 👉"
    }
}

fun randomString(): String {
    return (1..124).map { RANDOM_STRING.random() }.joinToString("")
}
