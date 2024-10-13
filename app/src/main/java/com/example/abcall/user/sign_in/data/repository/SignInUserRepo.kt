package com.example.abcall.user.sign_in.data.repository

import com.example.abcall.share.types.ResultI
import com.example.abcall.user.share.types.BackendError
import com.example.abcall.user.sign_in.data.network.SignInUserDataSource
import com.example.abcall.user.sign_in.data.types.SignInUserRepoI
import com.example.abcall.user.sign_in.data.types.SignInUserRequest
import com.example.abcall.user.sign_in.data.types.SignInUserResponse


class SignInUserRepo(private val datasource: SignInUserDataSource): SignInUserRepoI {
    override suspend fun signIn(request: SignInUserRequest): ResultI<SignInUserResponse, BackendError> {
        return datasource.signIn(request)
    }
}