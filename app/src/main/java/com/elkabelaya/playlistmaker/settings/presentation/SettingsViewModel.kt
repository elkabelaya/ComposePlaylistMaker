package com.elkabelaya.playlistmaker.settings.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.elkabelaya.playlistmaker.player.presentation.PlaybackButtonView
import kotlinx.coroutines.flow.StateFlow

abstract class SettingsViewModel : ViewModel(){
    abstract var isDarkMode: StateFlow<Boolean>
    abstract fun switch(isDarck: Boolean)
    abstract fun share()
    abstract fun support()
    abstract fun agreement()
}