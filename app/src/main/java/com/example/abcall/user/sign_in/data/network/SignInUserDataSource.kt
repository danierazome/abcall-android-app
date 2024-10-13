package com.example.abcall.user.sign_in.data.network

import com.example.abcall.share.types.ResultI
import com.example.abcall.user.share.types.BackendError
import com.example.abcall.user.share.types.backendErrorFromJson
import com.example.abcall.user.sign_in.data.types.SignInUserRequest
import com.example.abcall.user.sign_in.data.types.SignInUserResponse
import retrofit2.HttpException
import java.io.IOException

class SignInUserDataSource(private val apiService: SignInUserApiService) {
    suspend fun signIn(request: SignInUserRequest): ResultI<SignInUserResponse, BackendError> {
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