package com.elkabelaya.playlistmaker.common.presentation
import androidx.compose.ui.graphics.Color
import com.elkabelaya.playlistmaker.common.presentation.ypLightGray

data class ColorPalette(
    val accent: Color,
    val background: Color,
    val backgroundSecondary: Color,
    val backgroundTertiary: Color,
    val backgroundQuaternary: Color,
    val textTitle: Color,
    val text: Color,
    val textSecondary: Color,
    val hintSearch: Color,
    val textSearch: Color,
    val textInverted: Color,
    val backgroundInverted: Color,
    val switchThumb: Color,
    val switchTrack: Color,
)

private val ypBlack          = Color(0xFF1A1B22)
private val ypBlack25        = Color(0x801A1B22)
private val ypWhite          = Color(0xFFFFFFFF)
private val ypWhite25        = Color(0x40FFFFFF)
private val ypBlue           = Color(0xFF3772E7)
private val ypBlueLight      = Color(0xFF9FBBF3)
private val ypTextGray       = Color(0xFFAEAFB4)
private val ypLightGray      = Color(0xFFE6E8EB)
private val ypBackground     = Color(0x801A1B22)
private val defaultSwitch         = Color(0xFF00D6C3)
private val defaultSwitchLight    = Color(0xFF76EAE0)

val lightPalette = ColorPalette(
    accent = ypBlue,
    background = Color.White,
    backgroundSecondary = ypLightGray,//background_search
    backgroundTertiary = ypLightGray,
    backgroundQuaternary = ypWhite,
    backgroundInverted = ypBlack,
    textTitle = ypBlack,//textToolbar
    text = Color.Black,
    textSecondary = ypTextGray,
    hintSearch = ypTextGray,
    textSearch = ypBlack,
    textInverted = ypWhite,

    switchThumb = defaultSwitch,
    switchTrack = defaultSwitchLight
)

val darkPalette = ColorPalette(
    accent = ypBlue,
    background = ypBlack,
    backgroundSecondary = ypWhite,
    backgroundTertiary = ypLightGray,
    backgroundQuaternary = ypWhite,
    backgroundInverted = ypBlack,
    textTitle = ypWhite,
    text = ypWhite,
    textSecondary = ypWhite,
    hintSearch = ypBlack,
    textSearch = ypBlack,
    textInverted = ypBlack,
    switchThumb = ypBlue,
    switchTrack = ypBlueLight
)
