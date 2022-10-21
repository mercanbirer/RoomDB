package com.example.roomdb

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
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
