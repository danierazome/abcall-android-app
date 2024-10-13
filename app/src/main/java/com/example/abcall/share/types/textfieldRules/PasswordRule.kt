package com.example.abcall.share.types.textfieldRules

import com.example.abcall.R

class PasswordRules(private val minLength: Int = 6): RuleValidator {
    override fun validate(value: String): Validation {
        if (value.length < minLength) {
            return Validation(false, R.string.password_min_length)
        }

        return Validation()
    }
}