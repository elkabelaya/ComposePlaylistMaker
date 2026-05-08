package com.elkabelaya.playlistmaker.player.domain.repository

interface PlayerDefaultsRepository {
    fun getEmptyTime(): String
    fun addToastText(added: Boolean, playlist: String): String
}