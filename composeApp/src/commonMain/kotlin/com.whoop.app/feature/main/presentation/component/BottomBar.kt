package com.whoop.app.feature.main.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.whoop.app.design.component.TitleSmallText
import com.whoop.app.design.theme.whoop_text_black
import com.whoop.app.navigation.main.MainSections
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun BottomBar(
    navController: NavController,
    tabs: Array<MainSections>
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val mainSections = remember { MainSections.entries.toTypedArray() }
    val routes = remember { mainSections.map { it.route } }

    if (currentRoute in routes) {
        val currentSection = mainSections.first { it.route == currentRoute }

        Surface {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalDivider()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp, top = 14.dp)
                ) {
                    tabs.forEach { section ->
                        val selected = section == currentSection
                        BottomNavigationItem(
                            icon = {
                                Image(
                                    painter = if (!selected) {
                                        painterResource(section.iconDefaults)
                                    } else {
                                        painterResource(section.iconClicked)
                                    },
                                    contentDescription = null,
                                    modifier = Modifier.size(section.size.dp)
                                )
                            },
                            text = {
                                TitleSmallText(
                                    text = stringResource(section.title).replaceFirstChar { it.uppercase() },
                                    size = 8,
                                    color = whoop_text_black
                                )
                            },
                            selected = selected,
                            onSelected = {
                                if (section.route != currentRoute) {
                                    navController.navigate(section.route) {
                                        launchSingleTop = true
                                        restoreState = true
                                        popUpTo(
                                            findStartDestination(navController.graph).route
                                                ?: MainSections.HOME.route
                                        ) {
                                            saveState = true
                                        }
                                    }
                                }
                            },
                            modifier = Modifier.weight(1f),
                        )
                    }
                }
            }
        }
    }
}


private val NavGraph.startDestination: NavDestination?
    get() = findStartDestination()


private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}

@Composable
fun BottomNavigationItem(
    icon: @Composable() (BoxScope.() -> Unit),
    text: @Composable BoxScope.() -> Unit,
    selected: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.selectable(
            selected = selected,
            onClick = onSelected,
            interactionSource = MutableInteractionSource(),
            indication = null
        ),
    ) {
        Box(
            modifier = Modifier.layoutId("icon"),
            content = icon
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier.layoutId("text"),
            content = text
        )
    }
}

