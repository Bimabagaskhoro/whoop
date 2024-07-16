package com.whoop.app.feature.login.di

import com.whoop.app.feature.login.presentation.LoginViewModel
import org.koin.dsl.module

val loginModule = module {
    factory { LoginViewModel(get()) }
}