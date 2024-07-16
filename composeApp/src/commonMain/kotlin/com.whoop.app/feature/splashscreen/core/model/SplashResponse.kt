package com.whoop.app.feature.splashscreen.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SplashResponse(
    @SerialName("icon")
    val icon: String? = "",
    @SerialName("tint")
    val tint: String? = ""
)
