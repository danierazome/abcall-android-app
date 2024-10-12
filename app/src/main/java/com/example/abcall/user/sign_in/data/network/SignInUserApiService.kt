package com.example.abcall.user.sign_in.data.network

import com.example.abcall.user.sign_in.data.types.SignInUserRequest
import com.example.abcall.user.sign_in.data.types.SignInUserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInUserApiService {
    @POST("/user/api/v1/sign-in")
    suspend fun signIn(@Body request: SignInUserRequest): SignInUserResponse
}