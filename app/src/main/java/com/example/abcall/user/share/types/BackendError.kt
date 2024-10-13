package com.example.abcall.user.share.types

import com.google.gson.Gson

data class BackendError(val message: String = "Something went wrong")

fun backendErrorFromJson(json: String): BackendError {
    val gson = Gson()
    return gson.fromJson(json, BackendError::class.java)
}