package com.example.abcall.user.sign_in.config

import android.content.Context
import com.example.abcall.user.sign_in.data.network.SignInUserApiService
import com.example.abcall.user.sign_in.data.network.SignInUserDataSource
import com.example.abcall.user.sign_in.data.repository.SignInUserRepo
import com.example.abcall.user.sign_in.data.types.SignInUserRepoI
import com.example.abcall.user.sign_in.types.SignInModuleI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class SignInModule(private val context: Context): SignInModuleI {
    override val apiService: SignInUserApiService by lazy {

        val okHttpClient = OkHttpClient.Builder()
            .callTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .baseUrl("https://spring-app-226402391108.us-central1.run.app")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
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

