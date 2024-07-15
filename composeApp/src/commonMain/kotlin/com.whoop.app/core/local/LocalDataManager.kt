package com.whoop.app.core.local

import com.russhwolf.settings.Settings
import com.whoop.app.core.local.LocalConstant.PREF_ONE

class LocalDataManager(
    private val settings: Settings
) {
    fun saveData(localDataModel: LocalDataModel) {
        settings.putString(PREF_ONE, localDataModel.prefOne)
    }

    fun getData(): LocalDataModel? {
        val prefOne: String = settings.getString(key = PREF_ONE, defaultValue = "")

        return LocalDataModel(
            prefOne = prefOne,
        )
    }

    fun clearData() {
        settings.remove(PREF_ONE)
    }
}