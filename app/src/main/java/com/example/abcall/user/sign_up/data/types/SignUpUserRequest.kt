package com.example.abcall.user.sign_up.data.types

import com.google.gson.annotations.SerializedName

data class SignUpUserRequest(
    val name: String,
    val email: String,
    val id: Int,
    val password: String,
    @SerializedName("client_nit") val client: Int)
