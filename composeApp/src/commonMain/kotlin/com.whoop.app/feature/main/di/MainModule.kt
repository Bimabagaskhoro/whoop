package com.whoop.app.feature.main.di

import com.whoop.app.feature.main.presentation.MainViewModel
import org.koin.dsl.module

val mainModule = module {
    factory { MainViewModel() }
}