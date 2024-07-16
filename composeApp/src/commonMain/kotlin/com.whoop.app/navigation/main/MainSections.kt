package com.whoop.app.navigation.main

import com.whoop.app.navigation.utils.DestinationsConstant.HOME_SCREEN
import com.whoop.app.navigation.utils.DestinationsConstant.FIND_SCREEN
import com.whoop.app.navigation.utils.DestinationsConstant.CHAT_SCREEN
import org.jetbrains.compose.resources.DrawableResource
import whoop.composeapp.generated.resources.Res
import whoop.composeapp.generated.resources.ic_home_clicked
import whoop.composeapp.generated.resources.ic_home_default

enum class MainSections(
    val iconDefaults: DrawableResource,
    val iconClicked: DrawableResource,
    val size: Int,
    val route: String
) {
    HOME(
        iconDefaults = Res.drawable.ic_home_default,
        iconClicked = Res.drawable.ic_home_clicked,
        size = 24,
        route = HOME_SCREEN
    ),
    FIND(
        iconDefaults = Res.drawable.ic_home_default,
        iconClicked = Res.drawable.ic_home_clicked,
        size = 24,
        route = FIND_SCREEN
    ),
    CHAT(
        iconDefaults = Res.drawable.ic_home_default,
        iconClicked = Res.drawable.ic_home_clicked,
        size = 28,
        route = CHAT_SCREEN
    )
}
