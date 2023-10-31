package com.droidcon.androidversions.ui

import com.droidcon.androidversions.R

data class Version(
    val name: String,
    val resourceId: Int
)

val versionsList = listOf(
    Version(
        name = "Android 10",
        resourceId = R.drawable.android_10
    ),
    Version(
        name = "Android 11",
        resourceId = R.drawable.android_11
    ),
    Version(
        name = "Android 12",
        resourceId = R.drawable.android_12
    ),
    Version(
        name = "Android 13",
        resourceId = R.drawable.android_13
    ),
    Version(
        name = "Android 14",
        resourceId =R.drawable.android_14_preview
    ),

)