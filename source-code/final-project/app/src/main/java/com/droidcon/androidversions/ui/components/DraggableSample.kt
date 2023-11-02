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
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.droidcon.androidversions.R
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DraggableSample(
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current
    val contentSize = 100.dp
    val contentSizePx = with(density) { contentSize.toPx() }
    val animationSpec = spring<Float>(
        dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessMediumLow,
    )
    val positionalThreshold = { totalDistance: Float -> (totalDistance * 0.5f) }
    val velocityThreshold = { with(density) { 100.dp.toPx() } }

    val state = rememberSaveable(
        saver = AnchoredDraggableState.Saver(
            animationSpec = animationSpec,
            positionalThreshold = positionalThreshold,
            velocityThreshold = velocityThreshold
        )
    )
    {
        AnchoredDraggableState(
            initialValue = DragAnchors.Start,
            positionalThreshold = positionalThreshold,
            velocityThreshold = velocityThreshold,
            animationSpec = animationSpec
        )
    }
    Box(
        modifier = modifier
            .onSizeChanged { layoutSize ->
                val dragEndpoint = layoutSize.height - contentSizePx
                state.updateAnchors(
                    DraggableAnchors {
                        DragAnchors.entries.forEach { anchor ->
                            anchor at dragEndpoint * anchor.fraction

                        }
                    }
                )
            }
            .padding(16.dp)
    ) {
        VersionImage(
            modifier = Modifier
                .size(contentSize)
                .offset {
                    IntOffset(
                        x = 0,
                        y = state
                            .requireOffset()
                            .roundToInt()
                    )
                }
                .anchoredDraggable(state, orientation = Orientation.Vertical),
            resourceId = R.drawable.android_14_preview
        )
    }
}