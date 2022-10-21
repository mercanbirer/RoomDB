package com.example.roomdb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "user",
    indices = [Index(value = ["name"], unique = true)]
)

data class User(
    @ColumnInfo(name = "name")
    var name: String? = "",
    @ColumnInfo(name = "surname")
    var surname: String? = "",
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
