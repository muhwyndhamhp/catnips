package io.muhwyndhamhp.catnip.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.muhwyndhamhp.catnip.local.dao.CatDao
import io.muhwyndhamhp.catnip.local.dao.UserDao
import io.muhwyndhamhp.catnip.model.Cat
import io.muhwyndhamhp.catnip.model.User
import io.muhwyndhamhp.catnip.util.TypeConverter

@Database(entities = [User::class, Cat::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
    abstract fun catDao(): CatDao
}