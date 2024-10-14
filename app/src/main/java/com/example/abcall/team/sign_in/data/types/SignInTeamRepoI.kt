package com.example.abcall.team.sign_in.data.types

import com.example.abcall.share.types.ResultI
import com.example.abcall.share.types.server.BackendError

interface SignInTeamRepoI {
    suspend fun signIn(request: SignInTeamRequest): ResultI<SignInTeamResponse, BackendError>
}