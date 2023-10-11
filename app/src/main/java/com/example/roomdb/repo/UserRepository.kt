package com.example.roomdb.repo

import com.example.roomdb.database.UserDao
import com.example.roomdb.model.User
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val dao: UserDao,
) {
    suspend fun insertApplication(user: User) = dao.insertUser(user)

    fun removeUser(user: User) = dao.deleteUser(user)
}
