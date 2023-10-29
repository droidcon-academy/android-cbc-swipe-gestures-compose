package com.droidcon.androidversions.ui.components

enum class DragAnchors{
    START,CENTER,  END
}

enum class DynamicDragAnchors(val fraction: Float){
    HalfBeforeStart(-0.5f),
    QuarterBeforeStart(-0.25f),
    Start(0f),
    FirstQuarter(0.25f),
    Half(0.5f),
    End(1f)

}