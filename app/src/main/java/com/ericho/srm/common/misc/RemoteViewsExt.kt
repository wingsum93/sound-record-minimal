package com.ericho.srm.common.misc

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.RemoteViews
import androidx.annotation.IdRes

/**
 * A utility to call [RemoteViews.setViewVisibility] which normally accepts [VISIBLE] or [GONE]
 * with a boolean that chooses one or the other.
 */
fun RemoteViews.setViewVisibility(@IdRes viewId: Int, visible: Boolean) {
    setViewVisibility(viewId, if (visible) VISIBLE else GONE)
}
