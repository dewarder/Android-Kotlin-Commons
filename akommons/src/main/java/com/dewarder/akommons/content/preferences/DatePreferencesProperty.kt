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

package com.dewarder.akommons.content.preferences

import java.util.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class DatePreferencesProperty(
    private val defaultValue: Long,
    private val key: String?
) : ReadWriteProperty<SharedPreferencesProvider, Date> {

    override fun getValue(thisRef: SharedPreferencesProvider, property: KProperty<*>): Date {
        val key = key ?: property.name
        val date = Date()
        date.time = thisRef.sharedPreferences.getLong(key, defaultValue)
        return date
    }

    override fun setValue(thisRef: SharedPreferencesProvider, property: KProperty<*>, value: Date) {
        val key = key ?: property.name
        thisRef.sharedPreferences.save(key, value.time)
    }

}