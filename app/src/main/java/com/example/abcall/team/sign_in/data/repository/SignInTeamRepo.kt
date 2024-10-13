package com.example.abcall.team.sign_in.data.repository

import com.example.abcall.share.types.server.BackendError
import com.example.abcall.share.types.ResultI
import com.example.abcall.team.sign_in.data.network.SignInTeamDataSource
import com.example.abcall.team.sign_in.data.types.SignInTeamRepoI
import com.example.abcall.team.sign_in.data.types.SignInTeamRequest
import com.example.abcall.team.sign_in.data.types.SignInTeamResponse

class SignInTeamRepo(private val dataSource: SignInTeamDataSource): SignInTeamRepoI  {

    override suspend fun signIn(request: SignInTeamRequest): ResultI<SignInTeamResponse, BackendError> {
        return dataSource.signIn(request)
    }
}