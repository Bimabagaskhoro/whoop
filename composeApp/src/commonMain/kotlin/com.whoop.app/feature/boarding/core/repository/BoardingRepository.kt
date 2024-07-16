package com.whoop.app.feature.boarding.core.repository

import com.whoop.app.feature.boarding.core.model.BoardingResponse

interface BoardingRepository {
    suspend fun getBoarding(): BoardingResponse
}
