package com.example.abcall.user.sign_in.types

import com.example.abcall.user.share.types.textfieldRules.EmailRules
import com.example.abcall.user.share.types.textfieldRules.PasswordRules
import com.example.abcall.user.share.types.textfieldRules.Validation

fun passwordValidation(value: String): Validation {
    val validator = PasswordRules()
    return validator.validate(value)
}

fun emailValidation(value: String): Validation {
    val validator = EmailRules()
    return validator.validate(value)
}