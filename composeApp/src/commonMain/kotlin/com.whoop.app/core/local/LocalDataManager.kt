package com.whoop.app.core.local

import com.russhwolf.settings.Settings
import com.whoop.app.core.local.LocalConstant.ACCESS_TOKEN
import com.whoop.app.core.local.LocalConstant.DISPLAY_NAME
import com.whoop.app.core.local.LocalConstant.ID_TOKEN
import com.whoop.app.core.local.LocalConstant.PREF_ONE
import com.whoop.app.core.local.LocalConstant.PROFILE_URL

class LocalDataManager(
    private val settings: Settings
) {
    fun saveData(localPrefModel: LocalPrefModel) {
        settings.putString(PREF_ONE, localPrefModel.boardingPref)
    }

    fun getData(): LocalPrefModel {
        return LocalPrefModel(
            boardingPref = settings.getString(key = PREF_ONE, defaultValue = ""),
        )
    }

    fun clearData() {
        settings.remove(PREF_ONE)
        settings.remove(ID_TOKEN)
        settings.remove(ACCESS_TOKEN)
        settings.remove(DISPLAY_NAME)
        settings.remove(PROFILE_URL)
    }

    fun saveTokenAuth(localUserModel: LocalUserModel) {
        settings.putString(ID_TOKEN, localUserModel.idToken)
        settings.putString(ACCESS_TOKEN, localUserModel.accessToken)
        settings.putString(DISPLAY_NAME, localUserModel.displayName)
        settings.putString(PROFILE_URL, localUserModel.profilePicUrl)
    }

    fun getTokenAuth() : LocalUserModel {
        return LocalUserModel(
            idToken = settings.getString(key = ID_TOKEN, defaultValue = ""),
            accessToken = settings.getString(key = ACCESS_TOKEN, defaultValue = ""),
            displayName = settings.getString(key = DISPLAY_NAME, defaultValue = ""),
            profilePicUrl = settings.getString(key = PROFILE_URL, defaultValue = ""),
        )
    }
}
