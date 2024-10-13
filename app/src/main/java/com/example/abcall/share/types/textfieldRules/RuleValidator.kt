package com.example.abcall.share.types.textfieldRules

import com.example.abcall.R

interface RuleValidator {
    fun validate(value: String): Validation
}

    data class Validation(val result: Boolean = true, val message: Int = R.string.default_error)

