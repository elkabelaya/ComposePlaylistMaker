package com.elkabelaya.playlistmaker.common.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.visible
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview
import com.elkabelaya.playlistmaker.common.presentation.utils.dashedBorder

@Composable
fun AsyncImage(url: String?,
               imageLoaded: MutableState<Boolean> = remember { mutableStateOf(false) },
               modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        if (!imageLoaded.value) {
            Image(
                painter = painterResource(R.drawable.bg_placeholder),
                modifier = Modifier.fillMaxSize()
                    .padding(Dimens.paddingXL)
            )
        }
        if (!url.isNullOrBlank()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(url)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
                    .background(AppTheme.colors.backgroundQuaternary)
                    .padding(Dimens.padding7XL)
                    .visible(imageLoaded.value)
                ,
                onSuccess = {
                    imageLoaded.value = true
                }
            )
        }
    }
}

@AppPreview
@Composable
private fun AsyncImagePreview() {
    AppTheme {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            AsyncImage("123", remember { mutableStateOf(false) })
            AsyncImage("123", remember { mutableStateOf(true) })
        }
    }
}