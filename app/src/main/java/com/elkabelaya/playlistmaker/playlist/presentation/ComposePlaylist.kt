package com.elkabelaya.playlistmaker.playlist.presentation

import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.SheetValue.PartiallyExpanded
import androidx.compose.material3.SheetValue.Hidden
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.presentation.AppScreen
import com.elkabelaya.playlistmaker.common.presentation.AppTheme
import com.elkabelaya.playlistmaker.common.presentation.AsyncImage
import com.elkabelaya.playlistmaker.common.presentation.Dimens
import com.elkabelaya.playlistmaker.common.presentation.Image
import com.elkabelaya.playlistmaker.common.presentation.components.track.TrackItemList
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview
import com.elkabelaya.playlistmaker.playlist.domain.model.PlaylistState
import com.elkabelaya.playlistmaker.playlist.presentation.components.PlaylistMenu
import com.elkabelaya.playlistmaker.playlist.presentation.preview.ComposePlaylistPreviewProvider
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposePlaylist(viewModel: PlaylistViewModel, onBack: () -> Unit) {
    var showMenuSheet by remember { mutableStateOf(false) }
    var showDeleteAlert by remember { mutableStateOf(false) }
    val showDeleteTrackAlert: MutableState<Track?> = remember { mutableStateOf(null) }
    val menuSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    val state = viewModel.state.collectAsStateWithLifecycle()
    val density = LocalDensity.current
    var spacerHeightDp by remember { mutableStateOf(0.dp) }

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = if (state.value.tracks.isNotEmpty()) PartiallyExpanded else Hidden,
            skipHiddenState = if (state.value.tracks.isNotEmpty()) true else false
        )
    )

    if (showMenuSheet) {
        ModalBottomSheet(
            onDismissRequest = { showMenuSheet = false },
            sheetState = menuSheetState,
            containerColor = AppTheme.colors.background,
            scrimColor = Color.Black.copy(alpha = 0.5f)
        ) {
            PlaylistMenu(
                state.value.playlist,
                viewModel::onShare,
                viewModel::onEdit,
                {
                    showDeleteAlert = true
                }
            )
        }
    }

    if (showDeleteAlert) {
        DeleteAlert(
            state.value.playlist.name,
            confirm = {
                showDeleteAlert = false
                viewModel.onDelete()
                onBack()
            },
            dismiss = {
                showDeleteAlert = false
            }
        )
    }

    if (showDeleteTrackAlert.value != null) {
        TrackAlert(
            confirm = {
                showDeleteTrackAlert.value?.let {
                    viewModel.delete(it)
                }
                showDeleteTrackAlert.value = null
            },
            dismiss = {
                showDeleteTrackAlert.value = null
            }
        )
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = spacerHeightDp,
        sheetContainerColor = AppTheme.colors.background,
        sheetContent = {
            TrackItemList(
                state.value.tracks,
                viewModel::select
            ) { track ->
                showDeleteTrackAlert.value = track
            }
        },

    ) {
        AppScreen(
            null,
            onBack,
            AppTheme.colors.backgroundTertiary,
            AppTheme.colors.textSearch,
            false
        ) {
            Column {
                AsyncImage(state.value.playlist.coverUrl)
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(Dimens.paddingXS),
                    modifier = Modifier
                        .padding(
                            horizontal = Dimens.paddingM,
                            vertical = Dimens.paddingXL
                        )
                ) {
                    Texts(state.value)
                    Buttons(viewModel::onShare, { showMenuSheet = true })
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .onGloballyPositioned { coordinates ->
                            spacerHeightDp = with(density) { coordinates.size.height.toDp() }
                        }
                )
            }
        }
    }
}

@Composable
private fun Texts(state: PlaylistState ) {
    Text(
        state.playlist.name,
        style = AppTheme.typography.titleXLMedium,
        color = AppTheme.colors.textSearch
    )
    state.playlist.description?.let {
        Text(
            it,
            style = AppTheme.typography.textXLRegular
        )
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (state.playlist.duration.isNotEmpty()) {
            Text(
                state.playlist.duration,
                style = AppTheme.typography.textXLRegular
            )
        }
        if (state.playlist.duration.isNotEmpty() && state.playlist.count.isNotEmpty()) {
            Image(
                painter = painterResource(id = R.drawable.ic_dot),
                modifier = Modifier
                    .size(Dimens.iconS),
                colorFilter = ColorFilter.tint(AppTheme.colors.textSearch)
            )
        }
        if (state.playlist.count.isNotEmpty()) {
            Text(
                state.playlist.count,
                style = AppTheme.typography.textXLRegular
            )
        }
    }
}
@Composable
private fun Buttons(onShare: () -> Unit, onMenu: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Dimens.paddingS),
        modifier = Modifier.padding(top = Dimens.paddingXS)
    ) {
        IconButton(onClick = onShare) {
            Icon(painterResource(R.drawable.ic_share),
                contentDescription = null,
                tint = AppTheme.colors.textSearch
            )
        }
        IconButton(onClick = onMenu) {
            Icon(painterResource(R.drawable.ic_vertical_dots),
                contentDescription = null,
                tint = AppTheme.colors.textSearch
            )
        }
    }
}

@Composable
private fun TrackAlert(confirm: () -> Unit, dismiss: ()-> Unit) {
    AlertDialog(
        onDismissRequest = {
            //do nothing
        },
        title = {
            Text(text = stringResource(R.string.playlist_remove_track))
        },
        confirmButton = {
            TextButton(onClick = confirm) {
                Text(stringResource(R.string.playlist_remove_positive))
            }
        },
        dismissButton = {
            TextButton(onClick = dismiss) {
                Text(stringResource(R.string.playlist_remove_negative))

            }
        }
    )
}

@Composable
private fun DeleteAlert(name: String, confirm: () -> Unit, dismiss: ()-> Unit) {
    AlertDialog(
        onDismissRequest = {
            //do nothing
        },
        title = {
            Text(text = stringResource(R.string.playlist_remove_confirm, name))
        },
        confirmButton = {
            TextButton(onClick = confirm) {
                Text(stringResource(R.string.playlist_remove_positive))
            }
        },
        dismissButton = {
            TextButton(onClick = dismiss) {
                Text(stringResource(R.string.playlist_remove_negative))

            }
        }
    )
}

@AppPreview
@Composable
fun ComposePlaylistPreview(
    @PreviewParameter(ComposePlaylistPreviewProvider::class) model: PlaylistViewModel
) {
    AppTheme {
        ComposePlaylist(model){}
    }
}