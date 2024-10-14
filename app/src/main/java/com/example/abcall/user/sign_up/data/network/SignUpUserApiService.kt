package com.example.abcall.user.sign_up.data.network

import com.example.abcall.user.sign_up.data.types.SignUpUserRequest
import com.example.abcall.user.sign_up.data.types.SignUpUserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpUserApiService {
    @POST("/user/api/v1/sign-up")
    suspend fun signUp(@Body request: SignUpUserRequest): SignUpUserResponse
}