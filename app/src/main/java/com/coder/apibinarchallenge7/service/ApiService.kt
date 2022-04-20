package com.coder.apibinarchallenge7.service

import com.coder.apibinarchallenge7.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("api/v1/auth/login")
    fun loginUser(@Body request : LoginRequest): Call<LoginResponse>

    @POST("api/v1/auth/register")
    fun registerUser(@Body request : RegisterRequest): Call<RegisterResponse>

    @GET("api/v1/auth/me")
    fun auth(@Header("Authorization") token: String):Call<AuthResponse>
}