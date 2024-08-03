package com.eosdev.tokenauthentication.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eosdev.tokenauthentication.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {
    private val _loginState = mutableStateOf(false)
    val loginState: State<Boolean> = _loginState

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val success = authRepository.login(username, password)
                _loginState.value = success
            } catch (e: Exception) {
                _loginState.value = false
            } finally {
                _isLoading.value = false
            }
        }
    }
}