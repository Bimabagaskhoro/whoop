package com.whoop.app.di

import com.whoop.app.core.service.AppService
import com.whoop.app.core.service.AppServiceImpl
import org.koin.dsl.module

val provideServiceModule = module {
    single<AppService> { AppServiceImpl() }
}