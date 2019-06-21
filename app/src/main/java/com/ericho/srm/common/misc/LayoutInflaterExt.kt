package com.ericho.srm.common.misc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/** Inflates a layout and casts it to [T]. */
@Suppress("UNCHECKED_CAST")
fun <T : View> LayoutInflater.inflateAs(@LayoutRes res: Int, parent: ViewGroup? = null): T {
    return inflate(res, parent, false) as T
}
