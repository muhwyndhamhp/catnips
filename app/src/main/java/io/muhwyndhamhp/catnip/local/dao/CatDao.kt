package io.muhwyndhamhp.catnip.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.muhwyndhamhp.catnip.model.Cat

@Dao
interface CatDao {
    @Query("SELECT * FROM cat_data")
    fun getAllCat(): LiveData<List<Cat>>

    @Insert
    fun insertAllCat(catList: List<Cat>)
}