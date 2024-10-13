package com.example.abcall.user.sign_in.types

import com.example.abcall.share.types.server.BackendError
import com.example.abcall.user.sign_in.data.types.SignInUserResponse

sealed interface SignInUserState {
    data object Init: SignInUserState
    data object Loading: SignInUserState
    data class Error(val error: BackendError?): SignInUserState
    data class Success(val response: SignInUserResponse?): SignInUserState

}