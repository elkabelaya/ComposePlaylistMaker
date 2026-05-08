package com.elkabelaya.playlistmaker.search.domain.api

import com.elkabelaya.playlistmaker.common.domain.api.StateFullInteractor
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.search.domain.model.SearchState

interface SearchInteractor:StateFullInteractor<SearchState> {
    suspend fun changeQuery(query: String)
    fun changeFocus(isFocused: Boolean)
    fun clearQuery()
    fun select(track: Track)
    fun clearHistory()
    suspend fun refresh()
}