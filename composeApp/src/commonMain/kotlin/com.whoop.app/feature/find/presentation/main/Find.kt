package com.whoop.app.feature.find.presentation.main

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.whoop.app.design.component.BaseScreen
import com.whoop.app.feature.home.core.model.HomeUiModel
import com.whoop.app.feature.home.core.model.SwipeCard
import com.whoop.app.feature.home.core.model.listHomeUiModel
import com.whoop.app.navigation.main.MainAction
import com.whoop.app.utils.stringFrom
import kotlinx.coroutines.launch

@Composable
fun FindScreen(
    navController: NavHostController,
    mainAction: MainAction = MainAction(navController)
) {
    val lastIndex = listHomeUiModel.lastIndex
    val currentIndex = rememberSaveable { mutableIntStateOf(0) }

    var hint by remember {
        mutableStateOf("Try to swipe a card")
    }
    val profileList = remember { mutableListOf<HomeUiModel>() }.apply {
        addAll(listHomeUiModel)
    }

    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    BaseScreen(
        title = "home",
        navigateBack = {},
        leftIcon = {}
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(contentPadding),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                profileList.reversed().forEachIndexed { _, profile ->
                    FindSection(
                        profile = profile,
                        onSwipe = {
                            hint = "Swiped towards ${stringFrom(it)}"
                            currentIndex.intValue++
                            profileList.removeFirst()
                            val currentSnackBar = snackBarHostState.currentSnackbarData
                            currentSnackBar?.dismiss()
                            scope.launch {
                                val result = snackBarHostState
                                    .showSnackbar(
                                        message = "Undo swiped card",
                                        actionLabel = "Undo",
                                        duration = SnackbarDuration.Short
                                    )
                                if (result == SnackbarResult.ActionPerformed) {
                                    currentIndex.intValue-- // Decrement index
                                    profileList.add(0, profile)
                                }
                            }
                        }
                    )
                }
                if (currentIndex.intValue > lastIndex) {
                    Text(
                        text = "All Cards Swiped",
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


@Composable
fun FindSection(
    profile: HomeUiModel,
    onSwipe: (SwipeCard) -> Unit,
    modifier: Modifier = Modifier,
) {

    val offsetX = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Unspecified,
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = modifier
                .height(500.dp)
                .fillMaxWidth()
                .padding(16.dp)
                .graphicsLayer(
                    translationX = offsetX.value * 1.5f,
                    rotationZ = offsetX.value / 20
                )
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        scope.launch {
                            offsetX.snapTo(offsetX.value + delta)
                        }
                    },
                    onDragStopped = {
                        scope.launch {
                            when {
                                offsetX.value > 300 -> {
                                    offsetX.animateTo(
                                        targetValue = 1000f,
                                        animationSpec = tween(durationMillis = 300)
                                    )
                                    onSwipe(SwipeCard.RIGHT)
                                }

                                offsetX.value < -300 -> {
                                    offsetX.animateTo(
                                        targetValue = -1000f,
                                        animationSpec = tween(durationMillis = 300)
                                    )
                                    onSwipe(SwipeCard.LEFT)
                                }

                                else -> {
                                    offsetX.animateTo(
                                        targetValue = 0f,
                                        animationSpec = tween(durationMillis = 300)
                                    )
                                }
                            }
                        }
                    }
                ),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = profile.name,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 200.sp,
                    color = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "left",
                fontSize = 26.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier
                    .clickable {
                        scope.launch {
                            offsetX.animateTo(
                                targetValue = -1000f,
                                animationSpec = tween(durationMillis = 300)
                            )
                            onSwipe(SwipeCard.LEFT)
                        }
                    }
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "right",
                fontSize = 26.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier
                    .clickable {
                        scope.launch {
                            offsetX.animateTo(
                                targetValue = 1000f,
                                animationSpec = tween(durationMillis = 300)
                            )
                            onSwipe(SwipeCard.RIGHT)
                        }
                    }
                    .padding(8.dp)
            )
        }
    }
}