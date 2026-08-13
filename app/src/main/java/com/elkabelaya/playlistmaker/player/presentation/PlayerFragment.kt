package com.elkabelaya.playlistmaker.player.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.presentation.AppTheme
import com.elkabelaya.playlistmaker.player.di.playerModules
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.core.context.GlobalContext.unloadKoinModules
import org.koin.core.parameter.parametersOf

class PlayerFragment : Fragment() {

    private val track: Track? by lazy {
        requireArguments().getSerializable(INTENT_KEY) as? Track
    }

    private val viewModel: PlayerViewModel by viewModel {
        parametersOf(track)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(playerModules)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            AppTheme {
                DisposableEffect(Unit) {
                    onDispose {
                        viewModel.onPause()
                    }
                }
                ComposePlayer(
                    viewModel = viewModel,
                    onBack = { requireActivity().onBackPressedDispatcher.onBackPressed() }
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(playerModules)
    }

    companion object {
        const val INTENT_KEY = "INTENT_KEY"

        fun createArgs(track: Track): Bundle =
            Bundle().apply {
                putSerializable(INTENT_KEY, track)
            }
    }
}
