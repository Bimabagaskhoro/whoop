package com.whoop.app.feature.splashscreen.core.datasource

import io.ktor.client.statement.HttpResponse

interface SplashService {
    suspend fun getSplash(): HttpResponse
}