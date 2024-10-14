package com.example.abcall.user.sign_in.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.abcall.AbCallApplication
import com.example.abcall.share.types.textfieldRules.Validation
import com.example.abcall.share.types.textfieldRules.emailValidation
import com.example.abcall.share.types.textfieldRules.passwordValidation
import com.example.abcall.user.sign_in.data.types.SignInUserRepoI
import com.example.abcall.user.sign_in.data.types.SignInUserRequest
import com.example.abcall.user.sign_in.types.SignInUserState
import kotlinx.coroutines.launch


class SignInUserViewModel(private val repository: SignInUserRepoI): ViewModel() {

    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var emailIsValid by mutableStateOf(Validation())
        private set
    var passwordIsValid by mutableStateOf(Validation())
        private set
    var formIsValid by mutableStateOf(false)
        private set

    var state: SignInUserState by mutableStateOf(SignInUserState.Init)
        private set

    fun updateEmail(value: String) {
        email = value
        emailIsValid = emailValidation(value)
        updateFormIsValid()
    }

    fun updatePassword(value: String) {
        password = value
        passwordIsValid = passwordValidation(value)
        updateFormIsValid()
    }

    private fun updateFormIsValid() {
        formIsValid = passwordIsValid.result && emailIsValid.result
    }

    fun signIn() {
        state = SignInUserState.Loading
        viewModelScope.launch {
            val request = SignInUserRequest(email, password)
            val response = repository.signIn(request)
            state = if (response.isOk()) {
                SignInUserState.Success(response = response.ok)
            }else {
                SignInUserState.Error(error = response.err)
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