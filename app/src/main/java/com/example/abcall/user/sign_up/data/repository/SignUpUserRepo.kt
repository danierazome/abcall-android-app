package com.example.abcall.user.sign_up.data.repository

import com.example.abcall.share.types.ResultI
import com.example.abcall.share.types.server.BackendError
import com.example.abcall.user.sign_up.data.network.SignUpUserDataSource
import com.example.abcall.user.sign_up.data.types.SignUpUserRepoI
import com.example.abcall.user.sign_up.data.types.SignUpUserRequest
import com.example.abcall.user.sign_up.data.types.SignUpUserResponse

class SignUpUserRepo(private val dataSource: SignUpUserDataSource): SignUpUserRepoI {
    override suspend fun signUp(request: SignUpUserRequest): ResultI<SignUpUserResponse, BackendError> {
        return dataSource.signUp(request)
    }
}