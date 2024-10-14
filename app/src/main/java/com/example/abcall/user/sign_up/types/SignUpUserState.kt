package com.example.abcall.user.sign_up.types

import com.example.abcall.share.types.server.BackendError
import com.example.abcall.user.sign_up.data.types.SignUpUserResponse

sealed interface SignUpUserState{
    data object Init: SignUpUserState
    data object Loading: SignUpUserState
    data class Error(val error: BackendError?): SignUpUserState
    data class Success(val response: SignUpUserResponse?): SignUpUserState

}