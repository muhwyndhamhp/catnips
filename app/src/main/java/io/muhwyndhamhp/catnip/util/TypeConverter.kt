package io.muhwyndhamhp.catnip.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object TypeConverter {

    @TypeConverter
    @JvmStatic
    fun stringToStringList(data: String): List<String> =
        Gson().fromJson<List<String>>(data, object : TypeToken<List<String>>() {}.type)

    @TypeConverter
    @JvmStatic
    fun stringListToString(data: List<String>): String = Gson().toJson(data)
}