package com.whoop.app

import android.app.Application
import com.whoop.app.core.notification.NotificationInitializer

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        NotificationInitializer.onApplicationStart()
    }
}