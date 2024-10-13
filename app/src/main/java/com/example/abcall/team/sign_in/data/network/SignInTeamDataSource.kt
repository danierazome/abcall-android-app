package com.example.abcall.team.sign_in.data.network

import com.example.abcall.share.types.server.BackendError
import com.example.abcall.share.types.ResultI
import com.example.abcall.share.types.server.backendErrorFromJson
import com.example.abcall.team.sign_in.data.types.SignInTeamRequest
import com.example.abcall.team.sign_in.data.types.SignInTeamResponse
import retrofit2.HttpException
import java.io.IOException

class SignInTeamDataSource(private val apiService: SignInTeamApiService) {
    suspend fun signIn(request: SignInTeamRequest): ResultI<SignInTeamResponse, BackendError> {
        return try {
            val response = apiService.signIn(request)
            ResultI(response, null)
        }catch (e: IOException) {
            val error = BackendError("Something went wrong")
            ResultI(null, error)
        }catch (e: HttpException) {
            val error = e.response()?.errorBody()?.string()?.let { backendErrorFromJson(it) }
            ResultI(null, error)
        }

    }
}