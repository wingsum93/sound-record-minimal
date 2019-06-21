package com.ericho.srm.common

import android.app.Activity
import com.ericho.srm.common.permissions.RealPermissionChecker
import com.ericho.srm.common.providers.RealSdkProvider
import com.ericho.srm.common.providers.SdkProvider
import com.ericho.srm.common.Qualifiers.IO_DISPATCHER
import com.ericho.srm.common.Qualifiers.MAIN_DISPATCHER

import com.ericho.srm.common.intent.RealUrlLauncher
import com.ericho.srm.common.intent.UrlLauncher
import com.ericho.srm.common.permissions.PermissionChecker
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

object Qualifiers {
    const val MAIN_DISPATCHER = "main_dispatcher"
    const val IO_DISPATCHER = "io_dispatcher"
}

val commonModule = module {

    factory<CoroutineDispatcher>(named(MAIN_DISPATCHER)) { Dispatchers.Main }

    factory(named(IO_DISPATCHER)) { Dispatchers.IO }

    factory { RealPermissionChecker(get()) } bind PermissionChecker::class

    factory { RealSdkProvider() } bind SdkProvider::class

    factory { (activity: Activity) -> RealUrlLauncher(activity) } bind UrlLauncher::class
}
