package com.whoop.app.core.base.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("status")
    val status: String? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("data")
    val data: T? = null
)
