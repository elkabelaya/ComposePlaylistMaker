package com.elkabelaya.playlistmaker.common.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {

    val colors = if (!darkTheme) lightPalette
    else darkPalette
    val typography = getTypography(colors)

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        content = content
    )
}

private val LocalColors = staticCompositionLocalOf<ColorPalette> {
    lightPalette
}

private  val LocalTypography = compositionLocalOf { getTypography(lightPalette) }

object AppTheme {
    val colors: ColorPalette
        @Composable @ReadOnlyComposable
        get() = LocalColors.current
    val typography: AppTypography
        @Composable @ReadOnlyComposable
        get() = LocalTypography.current
}