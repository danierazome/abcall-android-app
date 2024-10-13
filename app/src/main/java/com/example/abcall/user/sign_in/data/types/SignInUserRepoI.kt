package com.example.abcall.user.sign_in.data.types

import com.example.abcall.share.types.server.BackendError
import com.example.abcall.share.types.ResultI

interface SignInUserRepoI {
    suspend fun signIn(request: SignInUserRequest): ResultI<SignInUserResponse, BackendError>
}

