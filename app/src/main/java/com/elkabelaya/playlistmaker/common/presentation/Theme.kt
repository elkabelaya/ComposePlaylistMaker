package com.elkabelaya.playlistmaker.common.presentation

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {

    val colors = if (!darkTheme) lightPalette
    else darkPalette



    CompositionLocalProvider(
        LocalColors provides colors,
        content = content
    )
}

private val LocalColors = staticCompositionLocalOf<ColorPalette> {
    lightPalette
}

object AppTheme {
    val colors: ColorPalette
        @Composable @ReadOnlyComposable
        get() = LocalColors.current
}