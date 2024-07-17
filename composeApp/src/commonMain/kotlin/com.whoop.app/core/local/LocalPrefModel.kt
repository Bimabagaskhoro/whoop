package com.whoop.app.core.local

data class LocalPrefModel(
    var boardingPref: String = "",
)

data class LocalUserModel(
    val idToken: String = "",
    val accessToken: String = "",
    val displayName: String = "",
    val profilePicUrl: String = "",
)
