package com.elkabelaya.playlistmaker.editplaylist.presentation

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.graphics.toColor
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.AppScreen
import com.elkabelaya.playlistmaker.common.presentation.AppTheme
import com.elkabelaya.playlistmaker.common.presentation.Dimens
import com.elkabelaya.playlistmaker.common.presentation.components.OutlinedInput
import com.elkabelaya.playlistmaker.common.presentation.components.buttons.AppButton
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview
import com.elkabelaya.playlistmaker.common.presentation.utils.dashedBorder
import com.elkabelaya.playlistmaker.common.presentation.utils.showAppToast
import com.elkabelaya.playlistmaker.editplaylist.domain.model.EditPlaylistMode
import com.elkabelaya.playlistmaker.editplaylist.presentation.preview.ComposeEditPlaylistPreviewProvider
import com.elkabelaya.playlistmaker.search.presentation.SearchViewModel
import com.elkabelaya.playlistmaker.search.presentation.preview.ComposeSearchPreviewProvider

@SuppressLint("LocalContextGetResourceValueCall")
@Composable
fun ComposeEditPlaylist(
    viewModel: EditPlaylistViewModel,
    onBack: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    val image by viewModel.image.collectAsState()
    val mode by viewModel.mode.collectAsState()
    val playlist by viewModel.playList.collectAsState()
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        viewModel.addImage(uri)
    }
    var showAlert by remember { mutableStateOf(false) }
    val context = LocalContext.current

    DisposableEffect(Unit) {
        onDispose {
            viewModel.dispose()
        }
    }

    if (showAlert) {
        Alert({
            showAlert = false
            onBack()
        }, {
            showAlert = false
        }
        )
    }

    AppScreen(
        title(mode),
        {
            if (state.needDialog) {
                showAlert = true
            } else {
                onBack()
            }
        }
    ) { ->

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(image) {
                imagePickerLauncher.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            }
            OutlinedInput(
                hint = stringResource(R.string.editplaylist_name),
                value = playlist?.name ?: "",
                onValueChange = viewModel::changeName,
                modifier = Modifier.padding(horizontal = Dimens.paddingM, vertical = Dimens.paddingXS)
            )
            OutlinedInput(
                hint = stringResource(R.string.editplaylist_description),
                value = playlist?.description ?: "",
                onValueChange = viewModel::changeDescription,
                modifier = Modifier.padding(horizontal = Dimens.paddingM, vertical = Dimens.paddingXS)
            )
            Spacer(modifier = Modifier.weight(1f))
            AppButton(
                text = stringResource(button(mode)),
                onClick = {
                    viewModel.save()
                    onBack()
                    showAppToast(
                        context,
                        context.getString(R.string.editplaylist_created_toast, playlist?.name ?: "")
                    )
                },
                enabled = state.isSaveEnabled,
                modifier = Modifier.padding(Dimens.paddingM)
            )
        }

    }
}

@StringRes
private fun title(mode: EditPlaylistMode):  Int {
    return when (mode) {
        EditPlaylistMode.NEW -> R.string.editplaylist_new_title
        else -> R.string.editplaylist_title
    }
}

@StringRes
private fun button(mode: EditPlaylistMode):  Int {
    return when (mode) {
        EditPlaylistMode.NEW -> R.string.editplaylist_create_button
        else -> R.string.editplaylist_save_button
    }
}

@Composable
private fun Image(image: String?, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(Dimens.paddingXL)
            .dashedBorder(
                width = dimensionResource(R.dimen.editplaylist_dash_height),
                color = colorResource(R.color.yp_text_gray),
                dashLength = dimensionResource(R.dimen.editplaylist_dash),
                gapLength = dimensionResource(R.dimen.editplaylist_dash),
                cornerRadius = dimensionResource(R.dimen.radius_xs)
            )
            .fillMaxWidth()
            .aspectRatio(1f)

            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        if (image == null) {
            Icon(
                painter = painterResource(id = R.drawable.ic_editplaylist_add_photo),
                contentDescription = null,
                modifier = Modifier,
                tint = colorResource(R.color.yp_text_gray)
            )
        } else {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.bg_placeholder),
                error = painterResource(R.drawable.bg_placeholder),
                fallback = painterResource(R.drawable.bg_placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

    }
}

@Composable
private fun Alert(confirm: () -> Unit, dismiss: ()-> Unit) {
        AlertDialog(
            onDismissRequest = {
                //do nothing
            },
            title = {
                Text(text = stringResource(R.string.editplaylist_dialog_title))
            },
            text = {
                Text(text = stringResource(R.string.editplaylist_unsave_dialog_description))
            },
            confirmButton = {
                TextButton(onClick = confirm) {
                    Text(stringResource(R.string.editplaylist_unsave_dialog_positive))
                }
            },
            dismissButton = {
                TextButton(onClick = dismiss) {
                    Text(stringResource(R.string.editplaylist_unsave_dialog_neutral))

                }
            }
        )
}

@AppPreview
@Composable
private fun ComposeEditPlaylistPreview(
    @PreviewParameter(ComposeEditPlaylistPreviewProvider::class) model: EditPlaylistViewModel
) {
    AppTheme {
        ComposeEditPlaylist(model){}
    }
}