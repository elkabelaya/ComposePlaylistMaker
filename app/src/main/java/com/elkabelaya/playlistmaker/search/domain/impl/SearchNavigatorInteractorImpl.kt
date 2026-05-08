package com.elkabelaya.playlistmaker.search.domain.impl

import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.domain.repository.NavigatorRepository
import com.elkabelaya.playlistmaker.search.domain.api.SearchNavigatorInteractor
import com.elkabelaya.playlistmaker.search.domain.repository.SearchNavigatorRepository

class SearchNavigatorInteractorImpl(private val repository: NavigatorRepository,
    val searchRepository: SearchNavigatorRepository): SearchNavigatorInteractor {
    override fun navigateTo(track: Track) {
        repository.navigateTo(searchRepository.getPlayer(track))
    }
}