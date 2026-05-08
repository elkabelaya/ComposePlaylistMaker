package com.elkabelaya.playlistmaker.playlist.presentation.repository

import android.content.Context
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.domain.model.Navigation
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.editplaylist.presentation.EditPlaylistFragment
import com.elkabelaya.playlistmaker.player.domain.repository.PlayerNavigatorRepository
import com.elkabelaya.playlistmaker.player.presentation.PlayerFragment
import com.elkabelaya.playlistmaker.playlist.domain.repository.PlaylistNavigatorRepository

class PlaylistNavigatorRepositoryImpl(val context: Context): PlaylistNavigatorRepository {


    override fun getPlayListEdit(playlist: Playlist): Navigation {
        return Navigation(R.id.action_playlist_editPlaylistFragment, EditPlaylistFragment.createArgs(playlist))
    }

    override fun getPlayer(track: Track): Navigation {
        return Navigation(R.id.action_playlist_playerFragment, PlayerFragment.createArgs(track))
    }
}