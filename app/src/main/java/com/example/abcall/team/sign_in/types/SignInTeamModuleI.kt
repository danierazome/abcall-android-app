package com.example.abcall.team.sign_in.types

import com.example.abcall.team.sign_in.data.network.SignInTeamApiService
import com.example.abcall.team.sign_in.data.network.SignInTeamDataSource
import com.example.abcall.team.sign_in.data.types.SignInTeamRepoI

interface SignInTeamModuleI {
    val apiService: SignInTeamApiService
    val dataSource: SignInTeamDataSource
    val repository: SignInTeamRepoI
}