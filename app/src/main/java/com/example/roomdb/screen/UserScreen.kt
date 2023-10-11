package com.example.roomdb.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.roomdb.R
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

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .fillMaxWidth(),
            label = {
                Text(text = stringResource(R.string.name))
            }
        )
        OutlinedTextField(
            value = surname.value,
            onValueChange = {
                surname.value = it
            },
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .fillMaxWidth(),
            label = {
                Text(text = stringResource(R.string.surname))
            }
        )
    }

    Button(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 64.dp, end = 64.dp, top = 180.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.DarkGray
        ), onClick = {
            coroutineScope.launch {
                viewModel.insertUser(
                    User(
                        name = name.value.text,
                        surname = surname.value.text
                    )
                )
            }
        }) {
        Text(stringResource(R.string.add_button))
    }
}
