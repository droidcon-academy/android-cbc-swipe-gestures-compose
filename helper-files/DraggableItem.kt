package com.droidcon.androidversions.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DraggableItem(
    // TODO: Add state variable
    content: @Composable BoxScope.() -> Unit,
    modifier: Modifier = Modifier,
    startAction: @Composable (BoxScope.() -> Unit)? = {},
    endAction: @Composable (BoxScope.() -> Unit)? = {}
) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clip(RectangleShape)
    ) {
        endAction?.let {
            endAction()
        }
        startAction?.let {
            startAction()
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterStart),
            // TODO add offset modifier
            // TODO add anchoredDraggable modifier
            content = content
        )
    }
}