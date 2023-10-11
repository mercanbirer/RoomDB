package com.example.roomdb.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdb.model.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun categoryDao(): UserDao
}



