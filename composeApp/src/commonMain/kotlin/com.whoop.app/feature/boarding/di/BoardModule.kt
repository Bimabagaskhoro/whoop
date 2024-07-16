package com.whoop.app.feature.boarding.di

import com.whoop.app.feature.boarding.core.datasource.BoardingService
import com.whoop.app.feature.boarding.core.datasource.BoardingServiceImpl
import com.whoop.app.feature.boarding.core.repository.BoardingRepository
import com.whoop.app.feature.boarding.core.repository.BoardingRepositoryImpl
import com.whoop.app.feature.boarding.presentation.BoardViewModel
import org.koin.dsl.module

val boardModule = module {
    single<BoardingService> { BoardingServiceImpl(get(), get()) }
    single<BoardingRepository> { BoardingRepositoryImpl(get()) }
    factory { BoardViewModel(get(), get()) }
}
