package com.droidcon.androidversions.ui.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidcon.androidversions.R
import com.droidcon.androidversions.ui.Version
import com.droidcon.androidversions.ui.theme.ashGreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VersionsListComponent(
    modifier: Modifier = Modifier,
    versionsList: List<Version>
) {
    val density = LocalDensity.current
    val actionSize = 80.dp
    val actionSizePx = with(density) { actionSize.toPx() }
    val animationSpec = tween<Float>()
    val positionalThreshold = { distance: Float -> distance * 0.5f }
    val velocityThreshHold = { with(density) { 100.dp.toPx() } }
    val state = rememberSaveable(
        saver = AnchoredDraggableState.Saver(
            animationSpec = animationSpec,
            positionalThreshold = positionalThreshold,
            velocityThreshold = velocityThreshHold
        )
    ) {
        AnchoredDraggableState(
            initialValue = DragAnchors.CENTER,
            positionalThreshold = positionalThreshold,
            velocityThreshold = velocityThreshHold,
            animationSpec = animationSpec,
//            confirmValueChange = { anchors ->
//               val answer =  anchors == DragAnchors.START
//                Log.d("VEEETO", "CHANGES $answer")
//                answer
//
//            }
        ).apply {
            updateAnchors(
                DraggableAnchors {
                    DragAnchors.START at -actionSizePx
                    DragAnchors.CENTER at 0f
                    DragAnchors.END at actionSizePx
                }
            )
        }
    }

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(top = 32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(versionsList, key = { it.name }) { version ->
            DraggableItem(state = state,
                content = {
                    VersionCard(version = version, modifier = Modifier.fillMaxWidth())
                },
                startAction = {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .background(color = ashGreen)){
                            ActionComponent(
                                modifier = Modifier.align(Alignment.CenterStart)
                            )
                        }
                },
                endAction = {
                    ActionComponent(
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
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
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.padding(top = 10.dp, bottom = 4.dp),
            painter = painterResource(id = R.drawable.ic_star_outline),
            contentDescription = "Mark as favourite",
            tint = Color.White
        )
        Text(text = "Save",
            color = Color.White, 
            fontSize = 14.sp
        )
    }
}