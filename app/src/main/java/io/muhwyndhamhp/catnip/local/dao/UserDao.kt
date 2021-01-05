package io.muhwyndhamhp.catnip.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.muhwyndhamhp.catnip.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUser(): LiveData<List<User>>

    @Insert
    fun insertUser(user: User)
}