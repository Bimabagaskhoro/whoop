package com.whoop.app.feature.boarding.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BoardingResponse(
    @SerialName("title")
    val title: String? = "",
    @SerialName("image")
    val image: String? = ""
)
