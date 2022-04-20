package com.coder.apibinarchallenge7.model


import com.google.gson.annotations.SerializedName

data class DataAuth(
    @SerializedName("email")
    val email: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("username")
    val username: String
)