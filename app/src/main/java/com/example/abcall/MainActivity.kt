package com.example.abcall


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.abcall.share.theme.AppTheme
import com.example.abcall.share.view_model.ThemeViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            val themeViewModel: ThemeViewModel by viewModels()

            AppTheme(userType = themeViewModel.type) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    IndexApp(changeTheme = {themeViewModel.type = it})
                }
            }
        }
    }


}



