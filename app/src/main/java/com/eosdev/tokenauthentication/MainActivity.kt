package com.eosdev.tokenauthentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eosdev.tokenauthentication.navigation.AppNavigation
import com.eosdev.tokenauthentication.ui.theme.TokenAuthenticationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TokenAuthenticationTheme {
                AppNavigation()
            }
        }
    }
}
