package com.whoop.app.feature.boarding.core.datasource

import com.whoop.app.core.base.config.AppConfig
import com.whoop.app.core.base.datasource.DataSource
import com.whoop.app.core.base.datasource.EndPointConstant.BOARDING_ENDPOINT
import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse

class BoardingServiceImpl(
    appConfig: AppConfig,
    httpClient: HttpClient,
) : DataSource(
    url = appConfig.baseUrlMock,
    client = httpClient,
), BoardingService {
    override suspend fun getBoarding(): HttpResponse {
        return getHttpResponse(endPoint = BOARDING_ENDPOINT)
    }
}
