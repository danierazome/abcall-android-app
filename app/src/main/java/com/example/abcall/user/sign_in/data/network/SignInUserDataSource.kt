package com.example.abcall.user.sign_in.data.network

import com.example.abcall.user.sign_in.data.types.SignInUserRequest
import com.example.abcall.user.sign_in.data.types.SignInUserResponse

class SignInUserDataSource(private val apiService: SignInUserApiService) {
    suspend fun signIn(request: SignInUserRequest): SignInUserResponse {
        return apiService.signIn(request)
    }
}