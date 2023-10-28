package com.droidcon.androidversions.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidcon.androidversions.ui.Version
import com.droidcon.androidversions.ui.theme.lightGreen

const val imageDesc = "Version Image"
@Composable
fun VersionCard(
    modifier: Modifier = Modifier,
    version: Version
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = lightGreen
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            VersionImage(resourceId = version.resourceId)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = version.name,
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 18.sp
                )
            )
        }
    }
}

/**
 * For the dynamic moving make it vertical, horizontal etc. or any direction
 * Would this be confusing, do I maintain it to horizontal
 * If I maintain it to horizontal, I may have to reduce the width of the card..
 * By the time I'm done working on the sample project I'll know
 */

@Composable
fun VersionImage(
    modifier: Modifier = Modifier,
    resourceId: Int
){
    Image(
        modifier = modifier.size(80.dp),
        painter = painterResource(id = resourceId),
        contentDescription = imageDesc
    )
}


