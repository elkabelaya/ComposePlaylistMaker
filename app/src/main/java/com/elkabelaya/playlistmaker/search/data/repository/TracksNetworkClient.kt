package com.elkabelaya.playlistmaker.search.data.repository

import com.elkabelaya.playlistmaker.common.data.model.NetworkResponse
import com.elkabelaya.playlistmaker.common.data.model.TracksDto

interface TracksNetworkClient {
    suspend fun getTracks(query: String): NetworkResponse<TracksDto?>
}