package com.example.abcall.user.sign_up.types

import com.example.abcall.user.sign_up.data.network.SignUpUserApiService
import com.example.abcall.user.sign_up.data.network.SignUpUserDataSource
import com.example.abcall.user.sign_up.data.types.SignUpUserRepoI

interface SignUpUserModuleI {
    val apiService: SignUpUserApiService
    val dataSource: SignUpUserDataSource
    val repository: SignUpUserRepoI
}