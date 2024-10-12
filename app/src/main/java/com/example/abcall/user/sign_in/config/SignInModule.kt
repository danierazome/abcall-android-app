package com.example.abcall.user.sign_in.config

import android.content.Context
import com.example.abcall.user.sign_in.data.network.SignInUserApiService
import com.example.abcall.user.sign_in.data.network.SignInUserDataSource
import com.example.abcall.user.sign_in.data.repository.SignInUserRepo
import com.example.abcall.user.sign_in.data.types.SignInUserRepoI
import com.example.abcall.user.sign_in.types.SignInModuleI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SignInModule(private val context: Context): SignInModuleI {
    override val apiService: SignInUserApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://spring-app-226402391108.us-central1.run.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SignInUserApiService::class.java)
    }

    override val dataSource: SignInUserDataSource by lazy {
        SignInUserDataSource(apiService)
    }

    override val repository: SignInUserRepoI by lazy {
        SignInUserRepo(dataSource)
    }
}

