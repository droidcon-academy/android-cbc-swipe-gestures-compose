package com.droidcon.androidversions.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidcon.androidversions.R
import com.droidcon.androidversions.ui.Version
import com.droidcon.androidversions.ui.theme.ashGreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VersionItemComponent(
    modifier: Modifier = Modifier,
    version: Version
) {
    val density = LocalDensity.current
    var show by rememberSaveable {
        mutableStateOf(true)
    }
    val actionSize = 80.dp
    val actionSizePx = with(density) { actionSize.toPx() }
    val animationSpec = tween<Float>()
    val positionalThreshold = { distance: Float -> distance * 0.5f }
    val velocityThreshold = { with(density) { 100.dp.toPx() } }

    val state = rememberSaveable(
        saver = AnchoredDraggableState.Saver(
            animationSpec = animationSpec,
            positionalThreshold = positionalThreshold,
            velocityThreshold = velocityThreshold
        )
    ) {
        AnchoredDraggableState(
            initialValue = DragAnchors.Start,
            positionalThreshold = positionalThreshold,
            velocityThreshold = velocityThreshold,
            animationSpec = animationSpec,
            confirmValueChange = { anchor ->
                val isDismiss = anchor == DragAnchors.PreHalf ||
                        anchor == DragAnchors.Half ||
                        anchor == DragAnchors.End
                if (isDismiss) {
                    show = false
                }
                true
            }
        )
    }
    AnimatedVisibility(visible = show, exit = fadeOut(spring())) {
        Box(
            modifier = modifier.onSizeChanged { layoutSize ->
                val dragEndpoint = layoutSize.width - actionSizePx
                state.updateAnchors(
                    DraggableAnchors {
                        DragAnchors.entries.forEach { anchor ->
                            anchor at (dragEndpoint * anchor.fraction)

                        }
                    }
                )
            }
        ) {
            DraggableItem(
                modifier = Modifier,
                state = state,
                content = {
                    VersionCard(
                        modifier = Modifier.fillMaxWidth(),
                        version = version
                    )
                },
                startAction = {
                    Box(
                        modifier = Modifier
                            .width(actionSize)
                            .fillMaxHeight()
                            .background(color = ashGreen)
                    ) {
                        ActionComponent(
                            modifier = Modifier.align(Alignment.CenterStart)
                        )
                    }
                },
                endAction = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(color = ashGreen)
                    ) {
                        ActionComponent(
                            modifier = Modifier.align(Alignment.CenterEnd)
                        )
                    }
                }

            )
        }
    }
}

@Composable
fun ActionComponent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.padding(top = 10.dp, bottom = 4.dp),
            painter = painterResource(id = R.drawable.ic_star_outline),
            contentDescription = "Mark as favourite",
            tint = Color.White
        )
        Text(
            text = "Save",
            color = Color.White,
            fontSize = 14.sp
        )
    }
}