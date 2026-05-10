package com.elkabelaya.playlistmaker.common.presentation

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.elkabelaya.playlistmaker.R


val appFontFamily = FontFamily(
    Font(R.font.ys_display_bold, FontWeight.Bold),
    Font(R.font.ys_display_medium, FontWeight.Medium),
    Font(R.font.ys_display_regular, FontWeight.Normal)
)

data class AppTypography (
    val titleXLMedium: TextStyle, //Title Вы искали
)

fun getTypography(palette: ColorPalette): AppTypography {
    return AppTypography(
        titleXLMedium = TextStyle(
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textL,
            color = palette.textTitle,
            textAlign = TextAlign.Center //?
        )
    )
}