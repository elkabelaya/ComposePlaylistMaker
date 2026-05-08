package com.elkabelaya.playlistmaker.media.presentation.repository

import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.domain.model.Navigation
import com.elkabelaya.playlistmaker.common.domain.model.Playlist
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.media.domain.repository.MediaNavigatorRepository
import com.elkabelaya.playlistmaker.editplaylist.presentation.EditPlaylistFragment
import com.elkabelaya.playlistmaker.player.presentation.PlayerFragment
import com.elkabelaya.playlistmaker.playlist.presentation.PlaylistFragment

class MediaNavigatorRepositoryImpl(): MediaNavigatorRepository {
    override fun getPlayer(item: Track): Navigation {
        return Navigation(R.id.action_media_playerFragment, PlayerFragment.createArgs(item))
    }

    override fun getPlaylist(item: Playlist): Navigation {
        return Navigation(R.id.action_media_playlistFragment, PlaylistFragment.createArgs(item))
    }


    override fun getNewPlayLst(): Navigation {
        return Navigation(R.id.action_media_newplaylistFragment, EditPlaylistFragment.createArgs())
    }
}