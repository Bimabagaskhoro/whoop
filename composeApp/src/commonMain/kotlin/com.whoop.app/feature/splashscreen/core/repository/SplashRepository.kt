package com.whoop.app.feature.splashscreen.core.repository

import com.whoop.app.core.base.utils.BaseResponse
import com.whoop.app.feature.splashscreen.core.model.SplashResponse

interface SplashRepository {
    suspend fun getSplash(): BaseResponse<SplashResponse>
}
