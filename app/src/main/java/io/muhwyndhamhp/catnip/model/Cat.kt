package io.muhwyndhamhp.catnip.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "cat_data")
data class Cat(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var images: List<String> = listOf(),
    var name: String = ""
): Parcelable