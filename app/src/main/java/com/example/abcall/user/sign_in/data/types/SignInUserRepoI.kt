package com.example.abcall.user.sign_in.data.types

import com.example.abcall.share.types.ResultI
import com.example.abcall.share.types.server.BackendError

interface SignInUserRepoI {
    suspend fun signIn(request: SignInUserRequest): ResultI<SignInUserResponse, BackendError>
}

