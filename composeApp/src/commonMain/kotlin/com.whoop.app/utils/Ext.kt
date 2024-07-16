package com.whoop.app.utils

import com.whoop.app.feature.home.core.model.SwipeCard

fun stringFrom(direction: SwipeCard): String {
    return when (direction) {
        SwipeCard.LEFT -> "Left 👈"
        SwipeCard.RIGHT -> "Right 👉"
    }
}
