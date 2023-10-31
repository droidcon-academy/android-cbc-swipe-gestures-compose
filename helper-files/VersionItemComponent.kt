package com.droidcon.androidversions.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidcon.androidversions.R
import com.droidcon.androidversions.ui.Version
import com.droidcon.androidversions.ui.theme.ashGreen

@Composable
fun VersionItemComponent(
    modifier: Modifier = Modifier,
    version: Version
) {
    DraggableItem(
        modifier = Modifier,
        content = {
            VersionCard(
                modifier = Modifier.fillMaxWidth(),
                version = version
            )
        },
        startAction = {
            Box(
                modifier = Modifier
                    .fillMaxWidth() // TODO use actionSize as the size
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