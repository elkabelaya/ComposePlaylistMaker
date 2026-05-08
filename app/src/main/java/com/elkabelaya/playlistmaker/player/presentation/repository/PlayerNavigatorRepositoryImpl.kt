package com.elkabelaya.playlistmaker.player.presentation.repository

import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.domain.model.Navigation
import com.elkabelaya.playlistmaker.editplaylist.presentation.EditPlaylistFragment
import com.elkabelaya.playlistmaker.player.domain.repository.PlayerNavigatorRepository

class PlayerNavigatorRepositoryImpl(): PlayerNavigatorRepository {

    override fun getNewPlayLst(): Navigation {
        return Navigation(R.id.action_player_newplaylistFragment, EditPlaylistFragment.createArgs())
    }
}