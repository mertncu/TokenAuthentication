package com.eosdev.tokenauthentication.service.auth

import com.eosdev.tokenauthentication.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import com.eosdev.tokenauthentication.models.User

interface AuthApiService {

    @Headers("Content-Type: application/json")
    @POST("Auth/Login")
    fun login(@Body user: User): Call<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST("Auth/Register")
    fun register(@Body user: User): Call<LoginResponse>

}