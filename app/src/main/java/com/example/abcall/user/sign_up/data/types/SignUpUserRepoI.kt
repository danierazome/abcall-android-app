package com.example.abcall.user.sign_up.data.types

import com.example.abcall.share.types.ResultI
import com.example.abcall.share.types.server.BackendError

interface SignUpUserRepoI {
    suspend fun signUp(request: SignUpUserRequest): ResultI<SignUpUserResponse, BackendError>
}