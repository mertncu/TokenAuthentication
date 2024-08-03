package com.eosdev.tokenauthentication.repository

import android.util.Log
import com.eosdev.tokenauthentication.models.User
import com.eosdev.tokenauthentication.service.auth.AuthApiService
import com.eosdev.tokenauthentication.utils.TokenManager
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: AuthApiService,
    private val tokenManager: TokenManager
) {
    private val tag = "AuthRepository"

    suspend fun login(email: String, password: String): Boolean {
        return try {
            val loginResponse = apiService.login(User(email, password))
            tokenManager.saveToken(loginResponse.token)
            tokenManager.saveRefreshToken(loginResponse.refreshToken)
            true
        } catch (e: Exception) {
            Log.e(tag, "Login failed: ${e.message}", e)
            false
        }
    }
}
