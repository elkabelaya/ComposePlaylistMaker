package com.elkabelaya.playlistmaker.editplaylist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.ComposeView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.signature.ObjectKey
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.presentation.AppTheme
import com.elkabelaya.playlistmaker.common.presentation.utils.FragmentCloseable
import com.elkabelaya.playlistmaker.common.presentation.utils.FragmentWithToolBar
import com.elkabelaya.playlistmaker.common.presentation.utils.observeOnce
import com.elkabelaya.playlistmaker.common.presentation.utils.onTextChanged
import com.elkabelaya.playlistmaker.common.presentation.utils.showAppToast
import com.elkabelaya.playlistmaker.databinding.FragmentEditplaylistBinding
import com.elkabelaya.playlistmaker.editplaylist.di.editplaylistModules
import com.elkabelaya.playlistmaker.editplaylist.domain.model.EditPlaylistMode
import com.elkabelaya.playlistmaker.search.presentation.ComposeSearch
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.core.context.GlobalContext.unloadKoinModules
import org.koin.core.context.loadKoinModules
import org.koin.core.parameter.parametersOf


class EditPlaylistFragment : FragmentCloseable() {

    private val playlist: Playlist? by lazy {
        requireArguments().getSerializable(INTENT_KEY) as? Playlist
    }
    private val viewModel: EditPlaylistViewModel by viewModel() {
        parametersOf(playlist)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(editplaylistModules)
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(editplaylistModules)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            AppTheme {
                ComposeEditPlaylist(viewModel, { close() })
            }
        }
    }

    companion object {
        const val INTENT_KEY = "INTENT_KEY"

        fun createArgs(): Bundle = Bundle()

        fun createArgs(playList: Playlist): Bundle =
            Bundle().apply {
                putSerializable(INTENT_KEY, playList)
            }
    }

}