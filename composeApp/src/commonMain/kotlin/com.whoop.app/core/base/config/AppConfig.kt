package com.whoop.app.core.base.config

import com.whoop.app.BuildKonfig

class AppConfig {
    val baseUrl: String
        get() = BuildKonfig.COINGECK0_URL
    val baseUrlMock: String
        get() = BuildKonfig.BASE_URL_MOCK
}