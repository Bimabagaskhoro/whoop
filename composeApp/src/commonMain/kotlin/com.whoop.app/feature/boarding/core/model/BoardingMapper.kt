package com.whoop.app.feature.boarding.core.model

object BoardingMapper {
    fun BoardingResponse.toBoardingUi(): List<BoardingUiModel> {
        return this.data?.map { dataOk ->
            BoardingUiModel(
                title = dataOk.title.orEmpty(),
                img = dataOk.image.orEmpty()
            )
        }.orEmpty()
    }
}
