package com.eosdev.tokenauthentication.models

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("userName")
    val userName: String? = null,
    @SerializedName("Email")
    val email: String? = null,
    @SerializedName("Password")
    val password: String? = null,
    @SerializedName("userSurname")
    val userSurname: String? = null
)
