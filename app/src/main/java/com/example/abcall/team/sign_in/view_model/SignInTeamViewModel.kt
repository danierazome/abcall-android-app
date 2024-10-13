package com.example.abcall.team.sign_in.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.abcall.AbCallApplication
import com.example.abcall.share.types.textfieldRules.emailValidation
import com.example.abcall.share.types.textfieldRules.passwordValidation
import com.example.abcall.share.types.textfieldRules.Validation
import com.example.abcall.team.sign_in.data.types.SignInTeamRepoI
import com.example.abcall.team.sign_in.data.types.SignInTeamRequest
import com.example.abcall.team.sign_in.types.SignInTeamState
import kotlinx.coroutines.launch

class SignInTeamViewModel(private val repository: SignInTeamRepoI): ViewModel() {

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

    var state: SignInTeamState by mutableStateOf(SignInTeamState.Init)
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
        state = SignInTeamState.Loading
        viewModelScope.launch {
            val request = SignInTeamRequest(email, password)
            val response = repository.signIn(request)
            state = if (response.isOk()) {
                SignInTeamState.Success(response = response.ok)
            }else {
                SignInTeamState.Error(error = response.err)
            }
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AbCallApplication)
                val repository = application.signInTeamContainer.repository
                SignInTeamViewModel(repository = repository)
            }
        }
    }
}