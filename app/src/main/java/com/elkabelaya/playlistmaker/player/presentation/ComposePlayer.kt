package com.elkabelaya.playlistmaker.player.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.AppScreen
import com.elkabelaya.playlistmaker.common.presentation.AppTheme
import com.elkabelaya.playlistmaker.common.presentation.Dimens
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview
import com.elkabelaya.playlistmaker.player.domain.model.PlayerState
import com.elkabelaya.playlistmaker.player.presentation.preview.ComposePlayerPreviewProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposePlayer(viewModel: PlayerViewModel, onBack: () -> Unit) {
    val state by viewModel.state.collectAsState()
    val isFavorite by viewModel.isFavorite.collectAsState()
    val playlists by viewModel.playlists.collectAsState()
    val track = viewModel.track

    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    AppScreen(
        title = null,
        onBack = onBack,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(Dimens.paddingXL),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(track?.coverUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.bg_placeholder),
                error = painterResource(R.drawable.bg_placeholder),
                fallback = painterResource(R.drawable.bg_placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(Dimens.radiusXS))
            )

            Spacer(modifier = Modifier.height(Dimens.paddingM))

            Text(
                text = track?.trackName ?: "",
                style = AppTheme.typography.titleXLMedium,
                color = AppTheme.colors.textTitle,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(Dimens.paddingXS))

            Text(
                text = track?.artistName ?: "",
                style = AppTheme.typography.titleMMedium,
                color = AppTheme.colors.textTitle,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(Dimens.padding8XL))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { showBottomSheet = true },
                    modifier = Modifier.size(Dimens.iconXL)
                        .clip(CircleShape)
                        .background(AppTheme.colors.backgroundGray)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_player_add),
                        contentDescription = "Add to playlist",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(Dimens.iconM)
                    )
                }

                IconButton(
                    onClick = { viewModel.togglePlay() },
                    modifier = Modifier.size(Dimens.iconXXL)
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (state is PlayerState.Playing) R.drawable.ic_player_pause_button
                            else R.drawable.ic_player_play_button
                        ),
                        contentDescription = if (state is PlayerState.Playing) "Pause" else "Play",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(Dimens.iconXXL)
                    )
                }

                IconButton(
                    onClick = { viewModel.toggleFavorite() },
                    modifier = Modifier.size(Dimens.iconXL)
                        .clip(CircleShape)
                        .background(AppTheme.colors.backgroundGray)
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (isFavorite) R.drawable.ic_player_heart_fill
                            else R.drawable.ic_player_heart_stroke
                        ),
                        contentDescription = "Favorite",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(Dimens.iconM)
                    )
                }
            }

            Spacer(modifier = Modifier.height(Dimens.paddingXS))

            Text(
                text = state.time,
                style = AppTheme.typography.titleMMedium,
                color = AppTheme.colors.textTitle,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(Dimens.padding6XL))

            TrackInfoRow(label = R.string.player_duration, value = track?.trackTime)
            TrackInfoRow(label = R.string.player_album, value = track?.collectionName)
            TrackInfoRow(label = R.string.player_year, value = track?.year)
            TrackInfoRow(label = R.string.player_genre, value = track?.primaryGenreName)
            TrackInfoRow(label = R.string.player_country, value = track?.country)
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            containerColor = AppTheme.colors.background,
            scrimColor = Color.Black.copy(alpha = 0.5f)
        ) {
            ComposePlayerBottomSheet(playlists,
                {
                    viewModel.createPlaylist()
                    showBottomSheet = false
                },
                {
                    viewModel.select(it)
                    showBottomSheet = false
                }
                )
        }
    }
}

@Composable
private fun TrackInfoRow(@StringRes label: Int, value: String?) {
    if (value != null && value.isNotEmpty()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimens.paddingXXS),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(label),
                style = AppTheme.typography.textXSRegular,
                color = AppTheme.colors.textSecondary,
                textAlign = TextAlign.Start
            )
            Text(
                text = value,
                style = AppTheme.typography.textMRegular,
                color = AppTheme.colors.textTitle,
                textAlign = TextAlign.End,
                maxLines = 1
            )
        }
    }
}

@AppPreview
@Composable
fun ComposePlayerPreview(
    @PreviewParameter(ComposePlayerPreviewProvider::class) model: PlayerViewModel
) {
    AppTheme {
        ComposePlayer(model, {})
    }
}
