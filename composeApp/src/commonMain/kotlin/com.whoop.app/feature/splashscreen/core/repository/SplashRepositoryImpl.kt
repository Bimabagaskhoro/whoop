package com.whoop.app.feature.splashscreen.core.repository

import com.whoop.app.core.base.utils.BaseResponse
import com.whoop.app.core.base.utils.makeRequest
import com.whoop.app.feature.splashscreen.core.datasource.SplashService
import com.whoop.app.feature.splashscreen.core.model.SplashResponse

class SplashRepositoryImpl(
    private val service: SplashService
) : SplashRepository {
    override suspend fun getSplash(): BaseResponse<SplashResponse> {
        return makeRequest {
            service.getSplash()
        }
    }
}
