package com.whoop.app.design.component

import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseBottomSheet(
    modifier: Modifier,
    contentColor: Color = MaterialTheme.colorScheme.primaryContainer,
    backgroundColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    content: @Composable () -> Unit,
    onDismissRequest: () -> Unit
) {
    val sheetState = SheetState(
        skipPartiallyExpanded = true,
        initialValue = SheetValue.Hidden,
        confirmValueChange = { true }
    )

    val scope = rememberCoroutineScope()

    scope.launch {
        if (!sheetState.isVisible) {
            sheetState.show()
        } else {
            sheetState.hide()
        }
    }
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        contentColor = contentColor,
        containerColor = backgroundColor,
        shape = BottomSheetDefaults.ExpandedShape,
        tonalElevation = 16.dp,
        dragHandle = {}
    ) {
        content()
    }

}