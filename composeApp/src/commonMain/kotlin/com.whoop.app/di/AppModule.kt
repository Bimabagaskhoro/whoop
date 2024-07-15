package com.whoop.app.di

fun appModule() = listOf(
    provideHttpModule,
    provideCommonModule,
)