package com.droidcon.androidversions.ui.components

enum class DragAnchors(val fraction: Float) {
    PreHalf(-0.5f),
    PreQuarter(-0.25f),
    Start(0f),
    FirstQuarter(0.25f),
    Half(0.5f),
    ThirdQuarter(0.75f),
    End(1f)
}
