package com.droidcon.androidversions.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
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
    Box(
        modifier = modifier
            .background(
            color = lightGreen
        ).clip(RectangleShape),

    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            VersionImage(resourceId = version.resourceId)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = version.name,
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 18.sp
                )
            )
        }
    }
}


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


