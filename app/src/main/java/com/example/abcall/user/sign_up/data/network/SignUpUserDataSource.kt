package com.example.abcall.user.sign_up.data.network

import com.example.abcall.share.types.ResultI
import com.example.abcall.share.types.server.BackendError
import com.example.abcall.share.types.server.backendErrorFromJson
import com.example.abcall.user.sign_up.data.types.SignUpUserRequest
import com.example.abcall.user.sign_up.data.types.SignUpUserResponse
import retrofit2.HttpException
import java.io.IOException

class SignUpUserDataSource(private val apiService: SignUpUserApiService) {
    suspend fun signUp(request: SignUpUserRequest): ResultI<SignUpUserResponse, BackendError> {
        return try {
            val response = apiService.signUp(request)
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