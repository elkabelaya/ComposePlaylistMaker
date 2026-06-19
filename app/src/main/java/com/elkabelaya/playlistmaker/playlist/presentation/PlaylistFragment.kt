package com.elkabelaya.playlistmaker.playlist.presentation

import android.R.attr.visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.compose.ui.platform.ComposeView
import androidx.core.content.ContextCompat.getColor
import androidx.core.view.doOnDetach
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.presentation.AppTheme
import com.elkabelaya.playlistmaker.common.presentation.TracksAdapter
import com.elkabelaya.playlistmaker.common.presentation.utils.FragmentCloseable
import com.elkabelaya.playlistmaker.common.presentation.utils.FragmentWithToolBar
import com.elkabelaya.playlistmaker.common.presentation.utils.onResult
import com.elkabelaya.playlistmaker.common.presentation.utils.setup
import com.elkabelaya.playlistmaker.common.presentation.utils.setupVerticalInsets
import com.elkabelaya.playlistmaker.common.presentation.utils.showAppToast
import com.elkabelaya.playlistmaker.databinding.FragmentPlaylistBinding
import com.elkabelaya.playlistmaker.playlist.di.playlistModules
import com.elkabelaya.playlistmaker.search.presentation.ComposeSearch
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.core.context.GlobalContext.unloadKoinModules
import org.koin.core.parameter.parametersOf

class PlaylistFragment : FragmentCloseable() {
    private val viewModel: PlaylistViewModel by viewModel{
        parametersOf(playlist)
    }
    private val playlist: Playlist? by lazy {
        requireArguments().getSerializable(INTENT_KEY) as? Playlist
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(playlistModules)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            AppTheme {
                ComposePlaylist(viewModel) {
                    close()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(playlistModules)
    }

    companion object {
        const val INTENT_KEY = "INTENT_KEY"

        fun createArgs(playlist: Playlist): Bundle =
            Bundle().apply {
                putSerializable(INTENT_KEY, playlist)
            }
    }
}