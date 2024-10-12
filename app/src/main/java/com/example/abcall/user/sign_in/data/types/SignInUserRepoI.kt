package com.example.abcall.user.sign_in.data.types

interface SignInUserRepoI {
    suspend fun signIn(request: SignInUserRequest): SignInUserResponse
}

