package com.whoop.app.di

import com.whoop.app.core.repository.AppRepository
import com.whoop.app.core.repository.AppRepositoryImpl
import org.koin.dsl.module

val provideRepositoryModule = module {
    single<AppRepository> { AppRepositoryImpl() }
}