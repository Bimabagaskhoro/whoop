package com.whoop.app.feature.splashscreen.core.datasource

import com.whoop.app.core.base.config.AppConfig
import com.whoop.app.core.base.datasource.DataSource
import com.whoop.app.core.base.datasource.EndPointConstant.SPLASH_ENDPOINT
import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse

class SplashServiceImpl(
    appConfig: AppConfig,
    httpClient: HttpClient,
) : DataSource(
    url = appConfig.baseUrlMock,
    client = httpClient,
), SplashService {
    override suspend fun getSplash(): HttpResponse {
        return getHttpResponse(endPoint = SPLASH_ENDPOINT)
    }
}