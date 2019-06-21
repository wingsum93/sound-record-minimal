package com.ericho.srm.common.lifecycle

import androidx.lifecycle.Lifecycle.Event.*
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

/**
 * A wrapper to easily provide a arch Lifecycle in places where they don't already exist, such as
 * a View or Service.
 *
 * @author Aidan Follestad (@afollestad)
 */
class SimpleLifecycle(provider: LifecycleOwner) : LifecycleRegistry(provider) {

    /** Handles the create, start, and resume lifecycle events. */
    fun onCreate() {
        handleLifecycleEvent(ON_CREATE)
        handleLifecycleEvent(ON_START)
        handleLifecycleEvent(ON_RESUME)
    }

    /** Handles the pause, stop, and destroy lifecycle events. */
    fun onDestroy() {
        handleLifecycleEvent(ON_PAUSE)
        handleLifecycleEvent(ON_STOP)
        handleLifecycleEvent(ON_DESTROY)
    }
}
