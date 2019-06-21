package com.ericho.srm.common.misc

import android.net.Uri

/** An extension wrapper to [Uri.parse]. */
fun String.toUri() = Uri.parse(this)!!
