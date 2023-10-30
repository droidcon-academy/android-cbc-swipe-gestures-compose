package com.droidcon.androidversions.ui.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import com.droidcon.androidversions.ui.theme.lightGreen
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DynamicDraggableSample(
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val animationSpec = tween<Float>()
    val positionalThreshold = { totalDistance: Float -> totalDistance * 0.5f }
    val velocityThreshold = { with(density) { 100.dp.toPx() } }
    val state  = rememberSaveable(saver = AnchoredDraggableState.Saver(
        animationSpec = animationSpec,
        positionalThreshold = positionalThreshold,
        velocityThreshold = velocityThreshold
    )) {
        AnchoredDraggableState(
            initialValue = DynamicDragAnchors.Half,
            positionalThreshold = positionalThreshold,
            velocityThreshold = velocityThreshold,
            animationSpec = animationSpec
        )
    }
    val contextSize = 100.dp
    val contentSizePx = with(density) { contextSize.toPx() }
    Box(modifier = modifier
        .onSizeChanged { layoutSize ->
            val dragEndPoint = layoutSize.width - contentSizePx
            state.updateAnchors(
                DraggableAnchors {
                    DynamicDragAnchors.entries.forEach { anchor ->
                        anchor at -(dragEndPoint * anchor.fraction)
                    }
                }
            )

        }
        ) {
        VersionImage(
            resourceId = R.drawable.android_14_preview,
            modifier = Modifier
                .padding(18.dp)
                .size(contextSize)
                .offset {
                    IntOffset(
                        x = state
                            .requireOffset()
                            .roundToInt(),
                        y = 0
                    )
                }
                .anchoredDraggable(state, Orientation.Horizontal)
                .background(
                    color = lightGreen
                )


        )
    }
}