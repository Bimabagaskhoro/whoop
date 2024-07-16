package com.whoop.app.feature.splashscreen.core.model

object SplashMapper {
    fun SplashResponse.toSplashUi() = this.data?.run {
        return SplashUiModel(
            icon = icon.orEmpty(),
            tint = tint.orEmpty().toLong()
        )
    } ?: SplashUiModel()
}
