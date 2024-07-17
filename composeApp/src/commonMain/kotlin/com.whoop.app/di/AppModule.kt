package com.whoop.app.di

import com.whoop.app.feature.boarding.di.boardModule
import com.whoop.app.feature.login.di.loginModule
import com.whoop.app.feature.main.di.mainModule
import com.whoop.app.feature.splashscreen.di.splashModule

fun appModule() = listOf(
    provideHttpModule,
    provideCommonModule,
    provideRepositoryModule,
    provideServiceModule,
    splashModule,
    boardModule,
    loginModule,
    mainModule
)
