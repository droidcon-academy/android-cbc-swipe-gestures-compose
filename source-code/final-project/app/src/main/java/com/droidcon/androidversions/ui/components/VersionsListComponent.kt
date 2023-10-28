package com.droidcon.androidversions.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.droidcon.androidversions.ui.Version

@Composable
fun VersionsListComponent(
    modifier: Modifier = Modifier,
    versionsList: List<Version>
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(top =32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(versionsList, key = { it.name }) { version ->
            VersionCard(version = version,
                modifier = Modifier.fillMaxWidth())
        }
    }
}