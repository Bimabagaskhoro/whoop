package com.whoop.app.feature.splashscreen.di

import com.whoop.app.feature.splashscreen.core.datasource.SplashService
import com.whoop.app.feature.splashscreen.core.datasource.SplashServiceImpl
import com.whoop.app.feature.splashscreen.core.repository.SplashRepository
import com.whoop.app.feature.splashscreen.core.repository.SplashRepositoryImpl
import com.whoop.app.feature.splashscreen.presentation.SplashViewModel
import org.koin.dsl.module

val splashModule = module {
    single<SplashService> { SplashServiceImpl(get(), get()) }
    single<SplashRepository> { SplashRepositoryImpl(get()) }
    factory { SplashViewModel(get(), get()) }
}