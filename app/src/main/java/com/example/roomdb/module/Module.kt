package com.example.roomdb.module

import android.app.Application
import androidx.room.Room
import com.example.roomdb.database.Database
import com.example.roomdb.database.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {
    @Provides
    @Singleton
    fun provideDb(application: Application): Database {
        return Room.databaseBuilder(
            application,
            Database::class.java,
            "MExpenseDb"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTripDao(
        mExpenseDb: Database
    ): UserDao = mExpenseDb.categoryDao()
}