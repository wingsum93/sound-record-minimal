package com.ericho.srm.common.providers

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.O

/** @author Aidan Follestad (@afollestad) */
interface SdkProvider {

    /**
     * Returns true of the device's SDK >= 26.
     */
    fun hasAndroidO(): Boolean
}

/** @author Aidan Follestad (@afollestad) */
class RealSdkProvider : SdkProvider {

    override fun hasAndroidO(): Boolean {
        return SDK_INT >= O
    }
}
