package com.droidcon.androidversions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidcon.androidversions.ui.components.DraggableSample
import com.droidcon.androidversions.ui.theme.AndroidVersionsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidVersionsAppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    DraggableSample(
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}

