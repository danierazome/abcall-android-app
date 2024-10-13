package com.example.abcall.share.types.textfieldRules

import com.example.abcall.share.types.textfieldRules.EmailRules
import com.example.abcall.share.types.textfieldRules.PasswordRules
import com.example.abcall.share.types.textfieldRules.Validation

fun passwordValidation(value: String): Validation {
    val validator = PasswordRules()
    return validator.validate(value)
}

fun emailValidation(value: String): Validation {
    val validator = EmailRules()
    return validator.validate(value)
}