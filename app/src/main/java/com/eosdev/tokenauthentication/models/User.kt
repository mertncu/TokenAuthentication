package com.eosdev.tokenauthentication.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("Email")
    val email: String? = null,
    @SerializedName("Password")
    val password: String? = null,
)
