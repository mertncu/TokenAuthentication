package com.eosdev.tokenauthentication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eosdev.tokenauthentication.viewmodel.LoginViewModel

@Composable
fun HomeScreen(viewModel: LoginViewModel) {
    val token by viewModel.token
    val email by viewModel.email

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the Home Screen!")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Email: $email")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Token: $token")
    }
}
