package com.coder.apibinarchallenge7.model


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("data")
    val dataRequest: DataRequest,
    @SerializedName("success")
    val success: Boolean
)