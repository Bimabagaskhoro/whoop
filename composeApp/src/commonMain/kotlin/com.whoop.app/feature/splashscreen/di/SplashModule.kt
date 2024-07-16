package com.whoop.app.feature.splashscreen.di

import com.whoop.app.feature.splashscreen.presentation.SplashViewModel
import org.koin.dsl.module

val splashModule = module {
    factory { SplashViewModel(get()) }
}