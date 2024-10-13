package com.example.abcall.share.types

class ResultI<R, E>(val ok: R?, val err: E?) {
    fun isOk(): Boolean {
        return ok != null
    }

    fun isErr(): Boolean {
        return err != null
    }
}