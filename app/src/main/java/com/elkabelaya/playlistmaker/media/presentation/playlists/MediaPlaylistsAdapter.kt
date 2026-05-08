package com.elkabelaya.playlistmaker.media.presentation.playlists

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Playlists

class MediaPlaylistsAdapter(val onClickItem: (Playlist) -> Unit) : RecyclerView.Adapter<MediaPlaylistViewHolder> () {
        var playlists: Playlists = emptyList()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaPlaylistViewHolder {
            return MediaPlaylistViewHolder.from(parent)
        }

        override fun onBindViewHolder(holder: MediaPlaylistViewHolder, position: Int) {
            holder.bind(playlists[position], onClickItem)
        }

        override fun getItemCount() = playlists.size

}