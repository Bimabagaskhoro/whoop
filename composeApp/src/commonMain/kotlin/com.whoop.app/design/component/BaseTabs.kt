package com.whoop.app.design.component

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class BaseTabsModel {
    First,
    Second
}

@Composable
fun BaseTabs(
    title: List<String> = listOf("", ""),
    contentFirst: @Composable () -> Unit,
    contentSecond: @Composable () -> Unit,
) {
    val (currentCategory, setCurrentCategory) = rememberSaveable { mutableStateOf(BaseTabsModel.First) }
    BaseTabsSection(
        title = title,
        selectedCategory = currentCategory,
        onCategorySelected = setCurrentCategory,
        modifier = Modifier.fillMaxWidth()
    )
    val tweenSpec = remember { getAnimSpec() }
    Crossfade(
        currentCategory,
        animationSpec = tweenSpec,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
    ) { category ->
        when (category) {
            BaseTabsModel.First -> contentFirst()
            BaseTabsModel.Second -> contentSecond()
        }
    }
}

@Composable
fun BaseTabsSection(
    title: List<String> = listOf("", ""),
    modifier: Modifier = Modifier,
    categories: List<BaseTabsModel> = listOf(
        BaseTabsModel.First, BaseTabsModel.Second
    ),
    selectedCategory: BaseTabsModel,
    onCategorySelected: (BaseTabsModel) -> Unit,
) {
    val selectedIndex = categories.indexOfFirst { it == selectedCategory }
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        TabIndicator(
            Modifier.tabIndicatorOffset(tabPositions[selectedIndex])
        )
    }

    Column {
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp
        )
        ScrollableTabRow(
            selectedTabIndex = selectedIndex,
            indicator = indicator,
            divider = {},
            edgePadding = 8.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            categories.forEachIndexed { index, category ->
                Tab(
                    selected = index == selectedIndex,
                    onClick = { onCategorySelected(category) },
                    modifier = modifier,
                    text = {
                        Text(
                            text = when (category) {
                                BaseTabsModel.First -> title[0]
                                BaseTabsModel.Second -> title[1]
                            },
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = if (index == selectedIndex) FontWeight.Bold
                                else FontWeight.Normal,
                                fontSize = 12.sp
                            )
                        )
                    }
                )
            }
        }
    }
}

private fun getAnimSpec(): TweenSpec<Float> {
    return TweenSpec(
        durationMillis = 600,
        easing = LinearOutSlowInEasing
    )
}

@Composable
private fun TabIndicator(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primaryContainer,
) {
    Spacer(
        modifier
            .width(5.dp)
            .height(3.dp)
            .background(color, RoundedCornerShape(percent = 50))
    )
}
