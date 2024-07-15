package com.whoop.app.di

import com.russhwolf.settings.Settings
import com.whoop.app.core.base.config.AppConfig
import com.whoop.app.core.local.LocalDataManager
import org.koin.dsl.module

val provideCommonModule = module {
    single { AppConfig() }
    single { Settings() }
    single { LocalDataManager(get()) }
}