package com.example.abcall.share.types.textfieldRules

import com.example.abcall.R

class NumberRule(
    private val minLength: Int = 6,
    private val maxLength: Int = 12): RuleValidator {
    override fun validate(value: String): Validation {
        val number = value.toIntOrNull()

        if (number == null || number < 0) {
            return Validation(false, R.string.num_invalid)
        }

        if (value.length < minLength) {
            return Validation(false, R.string.num_min_length)
        }

        if (value.length > maxLength) {
            return Validation(false, R.string.num_max_length)
        }

        return Validation()
    }
}