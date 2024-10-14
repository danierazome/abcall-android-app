package com.example.abcall.user.sign_up.config

import android.content.Context
import com.example.abcall.share.types.server.backendUrl
import com.example.abcall.user.sign_up.data.network.SignUpUserApiService
import com.example.abcall.user.sign_up.data.network.SignUpUserDataSource
import com.example.abcall.user.sign_up.data.repository.SignUpUserRepo
import com.example.abcall.user.sign_up.data.types.SignUpUserRepoI
import com.example.abcall.user.sign_up.types.SignUpUserModuleI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class SignUpUserModule(private val context: Context): SignUpUserModuleI {
    override val apiService: SignUpUserApiService by lazy {

        val okHttpClient = OkHttpClient.Builder()
            .callTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .baseUrl(backendUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(SignUpUserApiService::class.java)
    }

    override val dataSource: SignUpUserDataSource by lazy {
        SignUpUserDataSource(apiService)
    }

    override val repository: SignUpUserRepoI by lazy {
        SignUpUserRepo(dataSource)
    }
}
