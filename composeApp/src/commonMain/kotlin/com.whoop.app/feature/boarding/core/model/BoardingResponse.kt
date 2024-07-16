package com.whoop.app.feature.boarding.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BoardingResponse(
    @SerialName("status")
    val status: String? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("data")
    val data: List<BoardingDataResponse>? = null
) {

    @Serializable
    data class BoardingDataResponse(
        @SerialName("title")
        val title: String? = "",
        @SerialName("image")
        val image: String? = ""
    )
}
