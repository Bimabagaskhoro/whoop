package com.whoop.app.feature.boarding.di

import com.whoop.app.feature.boarding.presentation.BoardViewModel
import org.koin.dsl.module

val boardModule = module {
    factory { BoardViewModel(get()) }
}