package com.elkabelaya.playlistmaker.common.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.Dimens
import com.elkabelaya.playlistmaker.common.presentation.appFontFamily
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: String,
    containerColor: Color = colorResource( R.color.background),
    titleColor: Color = colorResource(R.color.text_toolbar),
    onBack: (() -> Unit)? = null) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor,
            titleContentColor = titleColor
        ),
        title = { Text(title,
            color = titleColor,
            fontSize = Dimens.textXL,
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Medium,
        ) },
        navigationIcon = {
            if (onBack != null) {
                IconButton(onClick = { onBack() }) {
                    Icon(painterResource(R.drawable.ic_arrow_back),
                        contentDescription = null,
                        tint = titleColor
                    )
                }
            }
        },
        //modifier = Modifier.background(colorResource( R.color.background))
    )
}


@AppPreview
@Composable
fun TopAppBarPreview() {
    Column {
        TopAppBar("Поиск")
        TopAppBar("Поиск", Color.Gray, Color.Blue) {}
    }
}
