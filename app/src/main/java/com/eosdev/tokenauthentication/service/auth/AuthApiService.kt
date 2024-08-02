package com.eosdev.tokenauthentication.service.auth

import com.eosdev.tokenauthentication.models.LoginResponse
import com.eosdev.tokenauthentication.models.User
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApiService {

    @Headers("Content-Type: application/json")
    @POST("Auth/Login")
    suspend fun login(@Body user: User): LoginResponse

    @Headers("Content-Type: application/json")
    @POST("Auth/RefreshToken")
    suspend fun refreshToken(@Body refreshToken: String): LoginResponse

    @Headers("Content-Type: application/json")
    @POST("Auth/Register")
    suspend fun register(@Body user: User): LoginResponse

}
