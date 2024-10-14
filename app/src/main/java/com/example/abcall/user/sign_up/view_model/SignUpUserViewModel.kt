package com.example.abcall.user.sign_up.view_model

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
import com.example.abcall.share.types.textfieldRules.nameValidator
import com.example.abcall.share.types.textfieldRules.numberValidator
import com.example.abcall.share.types.textfieldRules.passwordValidation
import com.example.abcall.user.sign_up.data.types.SignUpUserRepoI
import com.example.abcall.user.sign_up.data.types.SignUpUserRequest
import com.example.abcall.user.sign_up.types.SignUpUserState
import kotlinx.coroutines.launch

class SignUpUserViewModel(private val repository: SignUpUserRepoI): ViewModel() {

//    ---------- FIELDS
    var name by mutableStateOf("")
        private set
    var email by mutableStateOf("")
        private set
    var id by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var cPassword by mutableStateOf("")
        private set
    var client by mutableStateOf("")
        private set
//    ----------- VALIDATION
    var nameIsValid by mutableStateOf(Validation())
        private set
    var emailIsValid by mutableStateOf(Validation())
        private set
    var idIsValid by mutableStateOf(Validation())
        private set
    var passwordIsValid by mutableStateOf(Validation())
        private set
    var cPasswordIsValid by mutableStateOf(true)
        private set
    var clientIsValid by mutableStateOf(Validation())
        private set
    var formIsValid by mutableStateOf(false)
        private set

    var state: SignUpUserState by mutableStateOf(SignUpUserState.Init)
        private set

    fun updateName(value: String) {
        name = value
        nameIsValid = nameValidator(value)
        updateFormIsValid()
    }

    fun updateEmail(value: String) {
        email = value
        emailIsValid = emailValidation(value)
        updateFormIsValid()
    }

    fun updateId(value: String) {
        id = value
        idIsValid = numberValidator(value)
        updateFormIsValid()
    }

    fun updatePassword(value: String) {
        password = value
        passwordIsValid = passwordValidation(value)
        updateFormIsValid()
    }

    fun updateCPassword(value: String) {
        cPassword = value
        cPasswordIsValid = (password == cPassword) && passwordIsValid.result
        updateFormIsValid()
    }

    fun updateClient(value: String) {
        client = value
        clientIsValid = numberValidator(value)
        updateFormIsValid()
    }

    private fun updateFormIsValid() {
        formIsValid = nameIsValid.result && emailIsValid.result && idIsValid.result &&
            passwordIsValid.result && cPasswordIsValid && clientIsValid.result
    }

    private fun validateFormBeforeSubmit() {
        updateName(name)
        updateEmail(email)
        updateId(id)
        updatePassword(password)
        updateCPassword(cPassword)
        updateClient(client)
    }

    fun signUp() {
        validateFormBeforeSubmit()

        if (!formIsValid) {
            return
        }

        state = SignUpUserState.Loading
        viewModelScope.launch {
            val request = SignUpUserRequest(name, email, id.toInt(),  password, client.toInt())
            val response = repository.signUp(request)
            state = if (response.isOk()) {
                SignUpUserState.Success(response = response.ok)
            }else {
                SignUpUserState.Error(error = response.err)
            }
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AbCallApplication)
                val repository = application.signUpUserContainer.repository
                SignUpUserViewModel(repository = repository)
            }
        }
    }
}