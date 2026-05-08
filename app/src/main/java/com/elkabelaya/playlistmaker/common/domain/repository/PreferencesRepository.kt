package com.elkabelaya.playlistmaker.common.domain.repository

import com.elkabelaya.playlistmaker.common.domain.model.Tracks

interface PreferencesRepository {
    var isNightMode: Boolean
    var searchHistory: Tracks
}