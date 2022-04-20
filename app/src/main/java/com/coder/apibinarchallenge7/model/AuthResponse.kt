package com.coder.apibinarchallenge7.model


import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("data")
    val dataAuth: DataAuth,
    @SerializedName("success")
    val success: Boolean
)