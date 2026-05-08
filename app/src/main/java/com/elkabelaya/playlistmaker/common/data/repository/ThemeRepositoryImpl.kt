package com.elkabelaya.playlistmaker.common.data.repository

import androidx.appcompat.app.AppCompatDelegate
import com.elkabelaya.playlistmaker.common.domain.repository.ThemeRepository

class ThemeRepositoryImpl: ThemeRepository {
    override fun switchTheme(darkThemeEnabled: Boolean) {
        AppCompatDelegate.setDefaultNightMode(
            if (darkThemeEnabled) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            }
        )
    }
}