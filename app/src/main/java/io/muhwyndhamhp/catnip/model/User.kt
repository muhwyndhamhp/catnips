package io.muhwyndhamhp.catnip.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = "",
    var password: String = "",
    var email: String = "",
    var phone: String = "",
    var profileImage: String = ""
)