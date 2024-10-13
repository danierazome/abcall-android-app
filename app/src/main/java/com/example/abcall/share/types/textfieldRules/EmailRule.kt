package com.example.abcall.share.types.textfieldRules

import com.example.abcall.R

class EmailRules(
    private val regex: String = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"): RuleValidator {

    override fun validate(value: String): Validation {
        if (!value.matches(regex.toRegex())) {
            return Validation(false, R.string.invalid_email)
        }
        return  Validation()
    }
}