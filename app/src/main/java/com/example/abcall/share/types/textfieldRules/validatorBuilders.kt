package com.example.abcall.share.types.textfieldRules

fun passwordValidation(value: String): Validation {
    val validator = PasswordRules()
    return validator.validate(value)
}

fun emailValidation(value: String): Validation {
    val validator = EmailRules()
    return validator.validate(value)
}

fun nameValidator(value: String): Validation {
    val validator = NameRule()
    return validator.validate(value)
}

fun numberValidator(value: String): Validation {
    val validator = NumberRule()
    return validator.validate(value)
}