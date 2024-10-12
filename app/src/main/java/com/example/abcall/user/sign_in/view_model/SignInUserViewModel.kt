package com.example.abcall.user.sign_in.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.abcall.AbCallApplication
import com.example.abcall.user.sign_in.data.types.SignInUserRepoI
import com.example.abcall.user.sign_in.data.types.SignInUserRequest
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class SignInUserViewModel(private val repository: SignInUserRepoI): ViewModel() {

    fun signIn(email: String, password: String) {
        Log.d("<<<<LOGIN WITH >>>", "Email: $email, Password: $password")
        viewModelScope.launch {
            try {
                val request = SignInUserRequest(email, password)
                val response = repository.signIn(request)
                Log.d("<<<SIGN IN RESPONSE>>", response.toString())
            }catch (e: IOException) {
                e.message?.let { Log.d("<<<<IOException>>>>", it) }
            }catch (e: HttpException) {
                e.message?.let { Log.d("<<<<HttpException>>>>", it) }
            }
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AbCallApplication)
                val repository = application.signInUserContainer.repository
                SignInUserViewModel(repository = repository)
            }
        }
    }
}