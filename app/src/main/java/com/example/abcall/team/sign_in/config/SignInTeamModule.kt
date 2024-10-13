package com.example.abcall.team.sign_in.config

import android.content.Context
import com.example.abcall.share.types.server.backendUrl
import com.example.abcall.team.sign_in.data.network.SignInTeamApiService
import com.example.abcall.team.sign_in.data.network.SignInTeamDataSource
import com.example.abcall.team.sign_in.data.repository.SignInTeamRepo
import com.example.abcall.team.sign_in.data.types.SignInTeamRepoI
import com.example.abcall.team.sign_in.types.SignInTeamModuleI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class SignInTeamModule(private val context: Context): SignInTeamModuleI {
    override val apiService: SignInTeamApiService by lazy {

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
            .create(SignInTeamApiService::class.java)
    }

    override val dataSource: SignInTeamDataSource by lazy {
        SignInTeamDataSource(apiService)
    }

    override val repository: SignInTeamRepoI by lazy {
        SignInTeamRepo(dataSource)
    }
}
