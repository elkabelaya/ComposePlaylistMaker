package com.elkabelaya.playlistmaker.common.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.domain.mocks.mock1
import com.elkabelaya.playlistmaker.common.domain.mocks.mock2
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview

@Composable
fun PlaylistCard(
    playlist: Playlist,
    modifier: Modifier = Modifier
) {

    val itemHeight = dimensionResource(id = R.dimen.list_item_height)
    val imageSize  = 45.dp
    val cornerRadius = dimensionResource(id = R.dimen.radius_xxxs)
    val paddingH   = dimensionResource(id = R.dimen.padding_s)

    Row(
        modifier = modifier
            .height(itemHeight)
            .fillMaxWidth()
            .padding(horizontal = paddingH),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                .data(playlist.coverUrl) // Accepts String paths, Files, or Android Uris
                .build()
            ),
            contentDescription = null,
            modifier = Modifier
                .size(imageSize)
                .clip(RoundedCornerShape(Dimens.radiusXS))
            ,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = paddingH),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = playlist.name,
                style = AppTheme.typography.titleMMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(2.dp))
            playlist.description?.let {
                Text(
                    text = it,
                    style = AppTheme.typography.textXSRegular,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@AppPreview
@Composable
private fun PlaylistCardPreview() {
    AppTheme {
        Column {
            PlaylistCard(Playlist.mock1())
            PlaylistCard(Playlist.mock2())
        }
    }
}
