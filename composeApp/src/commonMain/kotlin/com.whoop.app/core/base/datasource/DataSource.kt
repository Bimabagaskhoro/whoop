package com.whoop.app.core.base.datasource

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

abstract class DataSource(
    private val url: String,
    private val client: HttpClient,
) {

    suspend fun getHttpResponse(endPoint: String): HttpResponse {
        val url = "$url$endPoint"
        return client.get(url) {
            contentType(ContentType.Application.Json)
        }
    }

    suspend fun postHttpResponse(endPoint: String, body: Any): HttpResponse {
        val url = "$url$endPoint"
        return client.post(url) {
            setBody(body)
            contentType(ContentType.Application.Json)
        }
    }
}
