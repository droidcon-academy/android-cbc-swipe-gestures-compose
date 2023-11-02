package com.droidcon.androidversions.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.droidcon.androidversions.R

@Composable
fun DraggableSample(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.padding(16.dp)
    ) {
        VersionImage(
            resourceId = R.drawable.android_14_preview
        )
    }
}