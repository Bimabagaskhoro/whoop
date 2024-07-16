package com.whoop.app.di

import com.whoop.app.feature.boarding.di.boardModule
import com.whoop.app.feature.splashscreen.di.splashModule

fun appModule() = listOf(
    provideHttpModule,
    provideCommonModule,
    provideRepositoryModule,
    provideServiceModule,
    splashModule,
    boardModule
)
