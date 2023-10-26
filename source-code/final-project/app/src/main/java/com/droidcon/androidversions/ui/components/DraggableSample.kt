package com.droidcon.androidversions.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DraggableSample(
    modifier: Modifier = Modifier
){
    VersionCard(
        modifier = Modifier.padding(16.dp)
    )
}