package com.example.abcall.team.sign_in.data.network

import com.example.abcall.team.sign_in.data.types.SignInTeamRequest
import com.example.abcall.team.sign_in.data.types.SignInTeamResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInTeamApiService {
    @POST("/team/api/v1/sign-in")
    suspend fun signIn(@Body request: SignInTeamRequest): SignInTeamResponse
}