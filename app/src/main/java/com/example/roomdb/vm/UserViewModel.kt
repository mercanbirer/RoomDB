package com.example.roomdb.vm

import androidx.lifecycle.ViewModel
import com.example.roomdb.model.User
import com.example.roomdb.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @ExperimentalCoroutinesApi
@Inject constructor(
    val daoRepo: UserRepository,
) : ViewModel() {

    suspend fun insertUser(user: User) {
        daoRepo.insertApplication(user)
    }

    fun deleteUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            daoRepo.removeUser(user)
        }
    }
}
