package com.example.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Delete
    fun deleteUser(title: User)
}



