package com.whoop.app.navigation.main

import com.whoop.app.navigation.utils.DestinationsConstant.HOME_SCREEN
import com.whoop.app.navigation.utils.DestinationsConstant.FIND_SCREEN
import com.whoop.app.navigation.utils.DestinationsConstant.CHAT_SCREEN
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import whoop.composeapp.generated.resources.Res
import whoop.composeapp.generated.resources.app_name
import whoop.composeapp.generated.resources.ic_chat_clicked
import whoop.composeapp.generated.resources.ic_chat_default
import whoop.composeapp.generated.resources.ic_find_clicked
import whoop.composeapp.generated.resources.ic_find_default
import whoop.composeapp.generated.resources.ic_home_clicked
import whoop.composeapp.generated.resources.ic_home_default
import whoop.composeapp.generated.resources.nav_title_chat
import whoop.composeapp.generated.resources.nav_title_find
import whoop.composeapp.generated.resources.nav_title_home

enum class MainSections(
    val title: StringResource,
    val iconDefaults: DrawableResource,
    val iconClicked: DrawableResource,
    val size: Int,
    val route: String
) {
    HOME(
        title = Res.string.nav_title_home,
        iconDefaults = Res.drawable.ic_home_default,
        iconClicked = Res.drawable.ic_home_clicked,
        size = 24,
        route = HOME_SCREEN
    ),
    FIND(
        title = Res.string.nav_title_find,
        iconDefaults = Res.drawable.ic_find_default,
        iconClicked = Res.drawable.ic_find_clicked,
        size = 24,
        route = FIND_SCREEN
    ),
    CHAT(
        title = Res.string.nav_title_chat,
        iconDefaults = Res.drawable.ic_chat_default,
        iconClicked = Res.drawable.ic_chat_clicked,
        size = 28,
        route = CHAT_SCREEN
    )
}
