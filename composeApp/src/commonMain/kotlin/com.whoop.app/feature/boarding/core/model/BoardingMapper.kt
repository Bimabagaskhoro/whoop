package com.whoop.app.feature.boarding.core.model

import com.whoop.app.core.base.utils.BaseResponse

object BoardingMapper {
    fun BaseResponse<List<BoardingResponse>>.toBoardingUi(): List<BoardingUiModel> {
        return this.data?.map { dataOk ->
            BoardingUiModel(
                title = dataOk.title.orEmpty(),
                img = dataOk.image.orEmpty()
            )
        }.orEmpty()
    }
}