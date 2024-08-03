package com.eosdev.tokenauthentication.utils

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = "data_store")

class TokenDataStore @Inject constructor(context: Context) {
    private val dataStore = context.dataStore

    private val TOKEN_KEY = stringPreferencesKey("token")
    private val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")

    val token: Flow<String?> = dataStore.data
        .map { preferences ->
            preferences[TOKEN_KEY]
        }

    val refreshToken: Flow<String?> = dataStore.data
        .map { preferences ->
            preferences[REFRESH_TOKEN_KEY]
        }

    suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = token
        }
    }

    suspend fun saveRefreshToken(refreshToken: String) {
        dataStore.edit { preferences ->
            preferences[REFRESH_TOKEN_KEY] = refreshToken
        }
    }

    suspend fun isTokenValid(): Boolean {
        val token = token.first()
        return !token.isNullOrEmpty() && !isTokenExpired(token)
    }

    private fun isTokenExpired(token: String): Boolean {

        return false
    }
}
