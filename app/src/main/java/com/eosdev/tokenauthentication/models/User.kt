package com.eosdev.tokenauthentication.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("userName")
    val userName: String? = null,
    @SerializedName("userId")
    val userId: Int? = null,
    @SerializedName("Email")
    val email: String? = null,
    @SerializedName("Password")
    val password: Int? = null,
    @SerializedName("userSurname")
    val userSurname: String? = null
)
