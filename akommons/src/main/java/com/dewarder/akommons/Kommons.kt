/*
 * Copyright (C) 2017 Artem Hluhovskyi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

@file:JvmName("Kommons")

package com.dewarder.akommons

import android.os.Handler
import android.os.Looper

val uiHandler by lazy { Handler(Looper.getMainLooper()) }

fun post(block: () -> Unit) =
    uiHandler.post(Runnable(block))

fun postDelayed(delay: Long, block: () -> Unit) =
    uiHandler.postDelayed(Runnable(block), delay)

inline fun <reified T> Any.ifInstance(block: T.() -> Unit) {
    if (this is T) block(this)
}

inline fun ifDebug(block: () -> Unit) {
    if (BuildConfig.DEBUG) {
        block.invoke()
    }
}