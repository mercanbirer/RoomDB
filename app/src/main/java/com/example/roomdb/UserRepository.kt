package com.example.roomdb

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val dao: UserDao,
) {
    suspend fun insertApplication(user: User) = dao.insertUser(user)

    fun removeUser(user: User) = dao.deleteUser(user)
}
