package com.eosdev.tokenauthentication.repository

import android.util.Log
import com.eosdev.tokenauthentication.models.LoginResponse
import com.eosdev.tokenauthentication.models.User
import com.eosdev.tokenauthentication.service.auth.AuthApiService
import com.eosdev.tokenauthentication.utils.TokenManager
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: AuthApiService,
    private val tokenManager: TokenManager
) {
    private val tag = "AuthRepository"

    suspend fun login(email: String, password: String): LoginResponse? {
        return try {
            val loginResponse = apiService.login(User(email, password))

            // Yanıtı loglayın
            Log.d(tag, "API Response: $loginResponse")

            val accessToken = loginResponse.data?.accessToken
            if (accessToken != null) {
                val token: String = accessToken.token ?: throw IllegalStateException("Token is null")
                val refreshToken: String = accessToken.expiration ?: throw IllegalStateException("Expiration is null")

                tokenManager.saveToken(token)
                tokenManager.saveRefreshToken(refreshToken)
                loginResponse
            } else {
                Log.e(tag, "AccessToken is null in the response")
                null
            }
        } catch (e: Exception) {
            Log.e(tag, "Login failed: ${e.message}", e)
            null
        }
    }
}


