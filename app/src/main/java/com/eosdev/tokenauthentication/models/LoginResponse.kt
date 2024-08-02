package com.eosdev.tokenauthentication.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val token: String,
    val refreshToken: String
)