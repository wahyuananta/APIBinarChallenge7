package com.coder.apibinarchallenge7.model


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val dataLogin: DataLogin,
    @SerializedName("success")
    val success: Boolean
)