package com.effectivemobile.data.utils

import androidx.room.TypeConverter

class DbListConverter {

    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(";").map { it.trim() }
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        return list.joinToString(";")
    }
}