package com.elkabelaya.playlistmaker.player.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.domain.mocks.mockList
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Playlists
import com.elkabelaya.playlistmaker.common.presentation.AppTheme
import com.elkabelaya.playlistmaker.common.presentation.Dimens
import com.elkabelaya.playlistmaker.common.presentation.components.buttons.ActionButton
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview
import com.elkabelaya.playlistmaker.player.presentation.preview.ComposePlayerPreviewProvider

@Composable
fun ComposePlayerBottomSheet(playlists: Playlists,
                             onCreatePlayList: ()-> Unit,
                             onSelectPlayList: (Playlist)-> Unit,
                             modifier: Modifier = Modifier
) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(Dimens.paddingM)
        ) {
            Text(
                text = stringResource(R.string.player_playlist_title),
                style = AppTheme.typography.titleXLMedium,
                color = AppTheme.colors.textTitle,
                modifier = Modifier.padding(bottom = Dimens.paddingS)
            )

            ActionButton(
                textId = R.string.player_playlist_create,
                onClick = onCreatePlayList,

            )
            playlists.forEach { playlist ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = Dimens.paddingXS)
                        .clickable(onClick = { onSelectPlayList(playlist) }),
                    horizontalArrangement = Arrangement.spacedBy(Dimens.paddingXS),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(playlist.coverUrl)
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(R.drawable.bg_placeholder),
                        error = painterResource(R.drawable.bg_placeholder),
                        fallback = painterResource(R.drawable.bg_placeholder),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(Dimens.playlistItemHeight)
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(Dimens.radiusXS))
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = playlist.name,
                            style = AppTheme.typography.titleMMedium,
                            color = AppTheme.colors.textTitle
                        )
                        Text(
                            text = playlist.count,
                            style = AppTheme.typography.textXSRegular,
                            color = AppTheme.colors.textSecondary
                        )
                    }
                }
            }
        }
}

@AppPreview
@Composable
fun ComposePlayerBottomSheetPreview() {
    ComposePlayerBottomSheet(Playlist.mockList(), {}, {})
}