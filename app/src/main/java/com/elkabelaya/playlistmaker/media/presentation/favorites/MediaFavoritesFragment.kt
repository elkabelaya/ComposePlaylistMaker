//package com.elkabelaya.playlistmaker.media.presentation.favorites
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.tooling.preview.PreviewParameter
//import androidx.core.view.isVisible
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.elkabelaya.playlistmaker.R
//import com.elkabelaya.playlistmaker.common.presentation.TracksAdapter
//import com.elkabelaya.playlistmaker.common.presentation.components.ComposeErrorView
//import com.elkabelaya.playlistmaker.common.presentation.components.track.TrackItemList
//import com.elkabelaya.playlistmaker.databinding.FragmentMediaFavoritesBinding
//import com.elkabelaya.playlistmaker.media.domain.model.MediaFavoritesState
//import com.elkabelaya.playlistmaker.media.presentation.preview.ComposeMediaFavoritesPreviewProvider
//import com.elkabelaya.playlistmaker.search.presentation.LoadingContent
//import com.elkabelaya.playlistmaker.search.presentation.preview.ComposeSearchPreviewProvider
//import org.koin.androidx.viewmodel.ext.android.viewModel
//import org.koin.compose.viewmodel.koinViewModel
//
//class MediaFavoritesFragment : Fragment() {
//
//    private var _binding: FragmentMediaFavoritesBinding? = null
//    private val binding get() = _binding!!
//    private val adapter: TracksAdapter
//    private val viewModel: MediaFavoritesViewModel by viewModel()
//
//    init {
//        adapter = TracksAdapter({ item ->
//            viewModel.select(item)
//        })
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentMediaFavoritesBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupViewModel()
//        setupList()
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//
//    private fun setupViewModel() {
////        viewModel.observeState().observe(viewLifecycleOwner) { state ->
////            when (state) {
////                is MediaFavoritesState.Loading -> {
////                    binding.error.isVisible = false
////                    binding.tracksList.isVisible = false
////                    binding.progressbar.root.isVisible = true
////                }
////                is MediaFavoritesState.Error -> {
////                    binding.error.isVisible = true
////                    binding.tracksList.isVisible = false
////                    binding.progressbar.root.isVisible = false
////                    binding.error.setState(state.errorState)
////
////                }
////                is MediaFavoritesState.Data -> {
////                    adapter.tracks = state.tracks
////                    adapter.notifyDataSetChanged()
////                    binding.error.isVisible = false
////                    binding.tracksList.isVisible = true
////                    binding.progressbar.root.isVisible = false
////                }
////            }
////        }
//    }
//
//    private fun setupList() {
//        binding.tracksList.layoutManager = LinearLayoutManager(requireContext())
//        binding.tracksList.adapter = adapter
//    }
//
//    companion object {
//        @JvmStatic
//        fun newInstance() =
//            MediaFavoritesFragment()
//    }
//
//}

