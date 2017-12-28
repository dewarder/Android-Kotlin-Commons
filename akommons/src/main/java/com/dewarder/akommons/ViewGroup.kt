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

@file:JvmName("ViewGroupUtils")

package com.dewarder.akommons

import android.view.View
import android.view.ViewGroup

val ViewGroup.views: List<View>
    get() = (0..childCount - 1).map { getChildAt(it) }

operator infix fun ViewGroup.plus(view: View) {
    addView(view)
}

operator infix fun ViewGroup.minus(view: View) {
    removeView(view)
}

operator fun ViewGroup.get(index: Int): View {
    return getChildAt(index)
}