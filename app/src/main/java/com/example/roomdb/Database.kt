package com.example.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun categoryDao(): UserDao
}



