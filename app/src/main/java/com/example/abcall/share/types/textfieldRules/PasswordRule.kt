package com.example.abcall.share.types.textfieldRules

import com.example.abcall.R

class PasswordRules(
    private val minLength: Int = 6,
    private val maxLength: Int = 12): RuleValidator {
    override fun validate(value: String): Validation {
        if (value.length < minLength) {
            return Validation(false, R.string.password_min_length)
        }

        if (value.length > maxLength) {
            return Validation(false, R.string.password_max_length)
        }

        return Validation()
    }
}