package com.elkabelaya.playlistmaker.search.domain.repository

interface SearchErrorRepository {
    fun getEmptyText(): String
    fun getWifiText(): String
}