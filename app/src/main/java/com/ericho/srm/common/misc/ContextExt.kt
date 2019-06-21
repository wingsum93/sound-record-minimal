package com.ericho.srm.common.misc

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

var toast: Toast? = null

/** Calls [Context.getSystemService] and casts the return value to [T]. */
inline fun <reified T> Context.systemService(name: String): T {
    return getSystemService(name) as T
}

/** Shows a toast in the receiving context, cancelling any previous. */
fun Context.toast(message: Int) {
    toast?.cancel()
    toast = Toast.makeText(this, message, LENGTH_LONG)
        .apply {
            show()
        }
}

/** Shows a toast in the receiving context, cancelling any previous. */
fun Context.toast(message: String) {
    toast?.cancel()
    toast = Toast.makeText(this, message, LENGTH_LONG)
        .apply {
            show()
        }
}

inline fun <reified T : Activity> Context.startActivity(
    flags: Int? = null,
    extras: Bundle? = null
) {
    this.startActivity(Intent(this, T::class.java)
        .applyIf(this is Service) {
            addFlags(FLAG_ACTIVITY_NEW_TASK)
        }
        .applyIf(flags != null) {
            addFlags(flags!!)
        }
        .applyIf(extras != null) {
            putExtras(extras!!)
        }
    )
}
