package com.whoop.app.feature.splashscreen.core.model

import com.whoop.app.core.base.utils.BaseResponse

object SplashMapper {
    fun BaseResponse<SplashResponse>.toSplashUi() = this.data?.run {
        return SplashUiModel(
            icon = icon.orEmpty(),
            tint = tint.orEmpty().toLong()
        )
    } ?: SplashUiModel()
}
