package com.example.roomdb.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.roomdb.model.User
import com.example.roomdb.vm.UserViewModel
import kotlinx.coroutines.launch

@Composable
fun UserScreen(
    viewModel: UserViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val name = remember { mutableStateOf(TextFieldValue("")) }
    val surname = remember { mutableStateOf(TextFieldValue("")) }

    Box {
        Column() {
            OutlinedTextField(
                value = name.value,
                onValueChange = {
                    name.value = it
                },
                label = {
                    Text(text = "Name")
                }
            )
            OutlinedTextField(
                value = surname.value,
                onValueChange = {
                    surname.value = it
                },
                label = {
                    Text(text = "SurName")
                }
            )
        }
        Button(modifier = Modifier.padding(top = 180.dp), onClick = {
            coroutineScope.launch {
                viewModel.insertUser(
                    User(
                        name = name.value.text,
                        surname = surname.value.text
                    )
                )
            }
        }) {
        }
    }
}