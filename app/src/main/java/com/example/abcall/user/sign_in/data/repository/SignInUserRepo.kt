package com.example.abcall.user.sign_in.data.repository

import com.example.abcall.user.sign_in.data.network.SignInUserDataSource
import com.example.abcall.user.sign_in.data.types.SignInUserRepoI
import com.example.abcall.user.sign_in.data.types.SignInUserRequest
import com.example.abcall.user.sign_in.data.types.SignInUserResponse


class SignInUserRepo(private val datasource: SignInUserDataSource): SignInUserRepoI {
    override suspend fun signIn(request: SignInUserRequest): SignInUserResponse {
        return datasource.signIn(request)
    }
}