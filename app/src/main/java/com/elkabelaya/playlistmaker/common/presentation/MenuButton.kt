package com.elkabelaya.playlistmaker.common.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview

@Composable
fun MenuButton(
    @StringRes textRes: Int,
    @DrawableRes iconRes: Int? = null,
    onClick: () -> Unit
) {
    MenuButton(stringResource(textRes), iconRes, onClick)
}
@Composable
fun MenuButton(
    text: String,
    @DrawableRes iconRes: Int? = null,
    onClick: () -> Unit
) {
    CompositionLocalProvider(LocalRippleConfiguration provides null) {
        TextButton(
            onClick = onClick,
            colors = ButtonDefaults.textButtonColors(
                contentColor = colorResource(id = R.color.text)
            ),
            contentPadding = PaddingValues(
                start = 0.dp,
                top = 0.dp,
                end = 0.dp,
                bottom = 0.dp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.list_item_height))
                .padding(horizontal = Dimens.paddingM)
        ) {
            Text(
                text = text,
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = Dimens.textM,
                color = colorResource(R.color.text),
                modifier = Modifier.weight(1f)
            )
            iconRes?.let {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                    tint = AppTheme.colors.textSecondary
                )
            }
        }
    }
}

@AppPreview
@Composable
private fun MenuButtonPreview() {
    AppTheme {
        Column {
            MenuButton("Test"){}
            MenuButton("Test", R.drawable.ic_root_settings){}
        }
    }
}