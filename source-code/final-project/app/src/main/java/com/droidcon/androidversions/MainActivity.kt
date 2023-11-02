package com.droidcon.androidversions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.droidcon.androidversions.ui.components.VersionsListComponent
import com.droidcon.androidversions.ui.theme.AndroidVersionsAppTheme
import com.droidcon.androidversions.ui.versionsList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidVersionsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VersionsListComponent(versionsList = versionsList)
                }
            }
        }
    }
}

