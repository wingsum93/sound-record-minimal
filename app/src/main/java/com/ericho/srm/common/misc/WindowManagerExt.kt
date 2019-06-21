package com.ericho.srm.common.misc

import android.util.DisplayMetrics
import android.view.WindowManager
import timber.log.Timber

/** Wraps data for [displayInfo]. */
data class DisplayInfo(
    val width: Int,
    val height: Int,
    val density: Int
)

/** Retrieves a [DisplayInfo] instance from a [WindowManager]. */
fun WindowManager.displayInfo(): DisplayInfo {
    val metrics = DisplayMetrics()
    defaultDisplay.getRealMetrics(metrics)
    val info = DisplayInfo(
        metrics.widthPixels,
        metrics.heightPixels,
        metrics.densityDpi
    )
    Timber.tag("WindowManagerExt")
    Timber.d("Display: ${info.width} x ${info.height} @ ${info.density}")
    return info
}
