package com.example.abcall.share.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ThemeViewModel: ViewModel() {
    var type by mutableStateOf(0)
}