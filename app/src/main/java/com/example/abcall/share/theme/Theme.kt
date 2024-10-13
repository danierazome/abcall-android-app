package com.example.abcall.share.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.abcall.share.theme.teamTheme.teamScheme
import com.example.abcall.share.theme.userTheme.userScheme


@Composable
fun AppTheme(
    darkTheme: Boolean = true,
    userType: Int = 0,
    // Dynamic color is available on Android 12+
    content: @Composable () -> Unit
) {
    val colorScheme = when(userType) {
        0 -> userScheme
        1 -> teamScheme
        else -> userScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

