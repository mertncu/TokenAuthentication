package com.eosdev.tokenauthentication.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eosdev.tokenauthentication.repository.AuthRepository
import com.eosdev.tokenauthentication.models.LoginResponse
import com.eosdev.tokenauthentication.models.AccessToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {
    private val _loginState = mutableStateOf(false)
    val loginState: State<Boolean> = _loginState

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _token = mutableStateOf("")
    val token: State<String> = _token

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val loginResponse = authRepository.login(email, password)
                if (loginResponse != null) {
                    _loginState.value = true
                    _token.value = loginResponse.data?.accessToken?.token.toString()
                    _email.value = email
                } else {
                    _loginState.value = false
                }
            } catch (e: Exception) {
                _loginState.value = false
            } finally {
                _isLoading.value = false
            }
        }
    }
}
