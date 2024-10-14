package com.example.abcall.share.types.textfieldRules

import com.example.abcall.R


class NameRule(
    private val minLength: Int = 6): RuleValidator {

    override fun validate(value: String): Validation {
        if (value.length < minLength) {
            return Validation(false, R.string.name_min_length)
        }

        return Validation()
    }
}