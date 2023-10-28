package com.droidcon.androidversions.ui.components

enum class DragAnchors{
    START, END
}

enum class DynamicDragAnchors(val fraction: Float){
    Start(0f),
    Half(0.5f),
    End(1f)
}