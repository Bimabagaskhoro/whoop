package com.whoop.app.feature.boarding.core.repository

import com.whoop.app.core.base.utils.makeRequest
import com.whoop.app.feature.boarding.core.datasource.BoardingService
import com.whoop.app.feature.boarding.core.model.BoardingResponse

class BoardingRepositoryImpl(
    private val service: BoardingService
) : BoardingRepository {
    override suspend fun getBoarding(): BoardingResponse {
        return makeRequest {
            service.getBoarding()
        }
    }
}
