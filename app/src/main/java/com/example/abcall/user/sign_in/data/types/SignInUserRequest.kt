package com.example.abcall.user.sign_in.data.types

import kotlinx.serialization.Serializable


@Serializable
data class SignInUserRequest(val email: String,val password: String)