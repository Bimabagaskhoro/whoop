package com.whoop.app.feature.boarding.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter
import com.whoop.app.core.base.utils.UiState
import com.whoop.app.core.base.utils.onSuccess
import com.whoop.app.design.component.BodyMediumText
import com.whoop.app.design.theme.whoop_text_black
import com.whoop.app.feature.boarding.core.model.BoardingUiModel
import com.whoop.app.utils.UtilsConstant.BOARDING_SAVE_PREF
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import whoop.composeapp.generated.resources.Res
import whoop.composeapp.generated.resources.btn_board

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BoardingScreen(
    openMainFromBoarding: () -> Unit,
    viewModel: BoardViewModel = koinInject()
) {
    val state by viewModel.uiState.collectAsState(UiState.Default)
    var boardingModel by rememberSaveable { mutableStateOf(listOf(BoardingUiModel())) }

    state
        .onSuccess {
            boardingModel = it
        }
    val pagerState = rememberPagerState(pageCount = { boardingModel.size })

    Scaffold { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(contentPadding)
        ) {
            HorizontalPager(
                modifier = Modifier.align(Alignment.Center),
                state = pagerState
            ) { page ->
                BoardingSection(
                    title = boardingModel[page].title,
                    image = boardingModel[page].img,
                    pagerState = pagerState,
                    onClick = {
                        viewModel.saveBoarding(boardingPref = BOARDING_SAVE_PREF)
                        openMainFromBoarding()
                    }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.wrapContentSize().navigationBarsPadding()
                    .align(Alignment.BottomStart)
            ) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier.padding(16.dp),
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pagerState.pageCount) { page ->
            val color by animateColorAsState(
                if (pagerState.currentPage == page) MaterialTheme.colorScheme.primary else Color.Gray
            )

            val width by animateDpAsState(
                if (pagerState.currentPage == page) 16.dp else 8.dp
            )

            Box(
                modifier = Modifier.padding(2.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.size(width, 8.dp)
                        .border(
                            width = 1.dp,
                            color = whoop_text_black,
                            shape = CircleShape
                        )
                        .background(color, shape = CircleShape)
                        .padding(horizontal = 2.dp)
                ) {}
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BoardingSection(
    title: String,
    image: String,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Icon(
            painter = rememberImagePainter(image),
            tint = Color.Unspecified,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(100.dp).align(Alignment.Center)
        )

        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(horizontal = 32.dp, vertical = 100.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    letterSpacing = (-0.05).sp,
                    color = whoop_text_black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                ),
                textAlign = TextAlign.Center,
            )
        }

        AnimatedVisibility(
            modifier = Modifier.align(Alignment.BottomEnd).padding(32.dp),
            visible = pagerState.currentPage == 2,
        ) {
            Column(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(12.dp)
                    ).clickable {
                        onClick()
                    }.border(
                        width = 1.dp,
                        color = whoop_text_black,
                        shape = RoundedCornerShape(12.dp)
                    ).padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BodyMediumText(
                    modifier = Modifier.padding(12.dp),
                    size = 18,
                    color = whoop_text_black,
                    text = stringResource(Res.string.btn_board)
                )
            }
        }
    }
}
