/**
 * Designed and developed by Aidan Follestad (@afollestad)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ericho.srm.notification

import android.app.Application
import android.app.NotificationManager
import android.content.Context.NOTIFICATION_SERVICE
import com.ericho.srm.common.misc.systemService
import com.ericho.srm.notification.provider.NotificationChannelBuilder
import com.ericho.srm.notification.provider.RealNotificationChannelBuilder
import org.koin.dsl.module

/** @author Aidan Follestad (@afollestad) */
val notificationsModule = module {
    factory<NotificationManager> {
        get<Application>().systemService(NOTIFICATION_SERVICE)
    }

    single<Notifications> {
        RealNotifications(get(), get(), get())
    }

    factory<NotificationChannelBuilder> { RealNotificationChannelBuilder() }
}
