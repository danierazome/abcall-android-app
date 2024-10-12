package com.example.abcall.user.sign_in.types

import com.example.abcall.user.sign_in.data.network.SignInUserApiService
import com.example.abcall.user.sign_in.data.network.SignInUserDataSource
import com.example.abcall.user.sign_in.data.types.SignInUserRepoI

interface SignInModuleI {
    val apiService: SignInUserApiService
    val dataSource: SignInUserDataSource
    val repository: SignInUserRepoI
}