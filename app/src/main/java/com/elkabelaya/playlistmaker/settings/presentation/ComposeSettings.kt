package com.elkabelaya.playlistmaker.settings.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.AppScreen
import com.elkabelaya.playlistmaker.common.presentation.AppTheme
import com.elkabelaya.playlistmaker.common.presentation.Dimens
import com.elkabelaya.playlistmaker.common.presentation.MenuButton
import com.elkabelaya.playlistmaker.common.presentation.appFontFamily
import com.elkabelaya.playlistmaker.common.presentation.components.ComposeSwitch
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview
import com.elkabelaya.playlistmaker.settings.presentation.preview.ComposeSettingsPreviewProvider

@Composable
fun ComposeSettings(viewModel:SettingsViewModel) {
    val isDark by viewModel.isDarkMode.collectAsState()
    AppScreen(R.string.main_settings){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NightModeSwitch(
                checked = isDark,
                onCheckedChange = {viewModel.switch(it)}
            )

            MenuButton(
                text = stringResource(id = R.string.settings_share),
                iconRes = R.drawable.ic_share,
                onClick = viewModel::share
            )
            MenuButton(
                text = stringResource(id = R.string.settings_support),
                iconRes = R.drawable.ic_settings_support,
                onClick = viewModel::support
            )
            MenuButton(
                text = stringResource(id = R.string.settings_agreement),
                iconRes = R.drawable.ic_arrow_right,
                onClick = viewModel::agreement
            )
        }
    }
}

@Composable
fun NightModeSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.paddingM)
            .height(dimensionResource(id = R.dimen.list_item_height)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.settings_theme),
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize   = Dimens.textM,
            color      = colorResource(id = R.color.text),
            modifier   = Modifier.weight(1f)
        )
        ComposeSwitch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}



@AppPreview
@Composable
fun ComposeSettingsPreview(
    @PreviewParameter(ComposeSettingsPreviewProvider::class) model: SettingsViewModel
) {
    AppTheme {
        ComposeSettings(model)
    }
}