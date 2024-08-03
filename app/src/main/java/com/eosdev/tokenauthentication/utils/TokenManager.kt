package com.eosdev.tokenauthentication.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class TokenManager @Inject constructor(private val tokenDataStore: TokenDataStore) {
    val token: Flow<String?> = tokenDataStore.token
    val refreshToken: Flow<String?> = tokenDataStore.refreshToken

    suspend fun saveToken(token: String) {
        tokenDataStore.saveToken(token)
    }

    suspend fun saveRefreshToken(refreshToken: String) {
        tokenDataStore.saveRefreshToken(refreshToken)
    }

    suspend fun getToken(): String? {
        return token.first()
    }

    suspend fun getRefreshToken(): String? {
        return refreshToken.first()
    }

    suspend fun clearTokens() {
        tokenDataStore.saveToken("")
        tokenDataStore.saveRefreshToken("")
    }

    suspend fun isTokenValid(): Boolean {
        return tokenDataStore.isTokenValid()
    }
}