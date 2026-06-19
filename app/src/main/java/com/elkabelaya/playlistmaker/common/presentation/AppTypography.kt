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
    val titleXLMedium: TextStyle,
    val titleMMedium: TextStyle,
    val titleXXLBold:TextStyle,
    val textXSRegular: TextStyle,
    val textMRegular: TextStyle,
    val textXLRegular: TextStyle
)

fun getTypography(palette: ColorPalette): AppTypography {
    return AppTypography(
        titleXLMedium = TextStyle(
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = Dimens.textL,
            color = palette.textTitle,
            textAlign = TextAlign.Center //?
        ),
        titleMMedium = TextStyle(
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = Dimens.textM,
            color = palette.text,
            textAlign = TextAlign.Left
        ),
        titleXXLBold = TextStyle(
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textXXL,
            color = palette.text,
            textAlign = TextAlign.Left
        ),
        textXSRegular = TextStyle(
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textXS,
            color = palette.textSecondary,
            textAlign = TextAlign.Left
        ),
        textMRegular = TextStyle(
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textM,
            color = palette.textTitle,
            textAlign = TextAlign.Left
        ),
        textXLRegular = TextStyle(
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textXL,
            color = palette.textSearch,
            textAlign = TextAlign.Left
        ),
    )
}