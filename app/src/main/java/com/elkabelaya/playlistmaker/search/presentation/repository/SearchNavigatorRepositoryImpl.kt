package com.elkabelaya.playlistmaker.search.presentation.repository

import android.content.Context
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.domain.model.Navigation
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.player.presentation.PlayerFragment
import com.elkabelaya.playlistmaker.search.domain.repository.SearchNavigatorRepository

class SearchNavigatorRepositoryImpl(): SearchNavigatorRepository {
    override fun getPlayer(item: Track): Navigation {
        return Navigation(R.id.action_search_playerFragment, PlayerFragment.createArgs(item))
    }
}