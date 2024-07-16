package com.whoop.app.feature.splashscreen.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SplashResponse(
    @SerialName("status")
    val status: String? = "",
    @SerialName("message")
    val message: String? = "",
    @SerialName("data")
    val data: SplashDataResponse? = null
) {
    @Serializable
    data class SplashDataResponse(
        @SerialName("icon")
        val icon: String? = "",
        @SerialName("tint")
        val tint: String? = ""
    )
}
