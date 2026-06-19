package com.elkabelaya.playlistmaker.common.presentation

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.StateFlow

interface StateFullViewModel<T> {
    fun observeState(): LiveData<T>
}

interface ComposeStateFullViewModel<T> {
    val state: StateFlow<T>
}