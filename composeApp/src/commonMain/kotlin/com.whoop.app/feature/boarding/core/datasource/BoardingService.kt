package com.whoop.app.feature.boarding.core.datasource

import io.ktor.client.statement.HttpResponse

interface BoardingService {
    suspend fun getBoarding(): HttpResponse
}