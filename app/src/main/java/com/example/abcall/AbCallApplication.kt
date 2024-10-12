package com.example.abcall

import android.app.Application
import com.example.abcall.user.sign_in.config.SignInModule
import com.example.abcall.user.sign_in.types.SignInModuleI

class AbCallApplication: Application() {

    lateinit var signInUserContainer: SignInModuleI

    override fun onCreate() {
        super.onCreate()
        signInUserContainer = SignInModule(this)
    }
}