package com.elkabelaya.playlistmaker.common.domain.repository

interface ThemeRepository {
    fun switchTheme(darkMode: Boolean)
}