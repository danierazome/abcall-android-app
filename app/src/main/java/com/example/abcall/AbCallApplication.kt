package com.example.abcall

import android.app.Application
import com.example.abcall.team.sign_in.config.SignInTeamModule
import com.example.abcall.team.sign_in.types.SignInTeamModuleI
import com.example.abcall.user.sign_in.config.SignInModule
import com.example.abcall.user.sign_in.types.SignInModuleI
import com.example.abcall.user.sign_up.config.SignUpUserModule
import com.example.abcall.user.sign_up.types.SignUpUserModuleI

class AbCallApplication: Application() {

    lateinit var signInUserContainer: SignInModuleI
    lateinit var signInTeamContainer: SignInTeamModuleI
    lateinit var signUpUserContainer: SignUpUserModuleI

    override fun onCreate() {
        super.onCreate()
        signInUserContainer = SignInModule(this)
        signInTeamContainer = SignInTeamModule(this)
        signUpUserContainer = SignUpUserModule(this)
    }
}