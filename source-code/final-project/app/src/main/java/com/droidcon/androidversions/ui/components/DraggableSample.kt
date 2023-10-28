package com.droidcon.androidversions.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.droidcon.androidversions.R
import com.droidcon.androidversions.ui.Version

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DraggableSample(
    modifier: Modifier = Modifier,
    version: Version = Version(resourceId = R.drawable.android_14_preview, name = "Android 14")
) {
    val density = LocalDensity.current
    val dragState = remember {
        AnchoredDraggableState(
            initialValue = DragAnchors.START,
            positionalThreshold = { totalDistance -> totalDistance * 0.5f },
            velocityThreshold = { with(density) { 100.dp.toPx() } },
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioHighBouncy,
                stiffness = Spring.StiffnessMediumLow
            ),
        ).apply {
            updateAnchors(
                DraggableAnchors {
                    DragAnchors.START at 0f
                    DragAnchors.END at 600f
                }
            )
        }
    }

    Box(
        modifier = modifier
    ) {
        VersionCard(
            version = version,
            modifier = Modifier
                .padding(16.dp)
                .offset {
                    IntOffset(
                        x = dragState
                            .requireOffset()
                            .toInt(),
                        y = 0
                    )
                }
                .anchoredDraggable(state = dragState, orientation = Orientation.Horizontal)
        )
    }
}