package com.elkabelaya.playlistmaker.common.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.components.TopAppBar
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview
import com.elkabelaya.playlistmaker.search.presentation.SearchViewModel

@Composable
fun AppScreen(
    @StringRes title:  Int?,
    onBack: (() -> Unit)? = null,
    containerColor: Color = AppTheme.colors.background,
    titleColor: Color = AppTheme.colors.textTitle,
    usePaddings: Boolean = true,
    content: @Composable () -> Unit) {
    Scaffold(
        containerColor = containerColor,
        topBar = {
            TopAppBar(
                if (title != null) stringResource(title) else "",
                containerColor = Color.Transparent,
                titleColor = titleColor,
                onBack
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if (usePaddings) {
                        Modifier.padding(innerPadding)
                    } else {
                        Modifier
                    }
                )

        ) {
            content()
        }
    }
}

@AppPreview
@Composable
private fun AppScreenPreview1() {
    AppTheme {
        AppScreen(R.string.main_search, {}) {
            Text("Some view")
        }
    }
}

@AppPreview
@Composable
private fun AppScreenPreview2() {
    AppTheme {
        AppScreen(R.string.main_search, {},
            containerColor = Color.Gray,
            titleColor = Color.Blue,
            usePaddings = false) {
            Text("Some view")
        }
    }
}