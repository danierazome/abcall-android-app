package com.example.abcall.team.sign_in.types

import com.example.abcall.share.types.server.BackendError
import com.example.abcall.team.sign_in.data.types.SignInTeamResponse

sealed interface SignInTeamState {
    data object Init: SignInTeamState
    data object Loading: SignInTeamState
    data class Error(val error: BackendError?): SignInTeamState
    data class Success(val response: SignInTeamResponse?): SignInTeamState

}