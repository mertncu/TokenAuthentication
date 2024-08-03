package com.eosdev.tokenauthentication.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eosdev.tokenauthentication.ui.HomeScreen
import com.eosdev.tokenauthentication.ui.LoginScreen
import com.eosdev.tokenauthentication.viewmodel.LoginViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val loginViewModel: LoginViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController, loginViewModel) }
        composable("home") { HomeScreen(loginViewModel) }
    }
}
