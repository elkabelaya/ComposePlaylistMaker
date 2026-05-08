package com.elkabelaya.playlistmaker.common.domain.use_case

interface ClickDebounceUseCase {
    fun canClickDebounced() : Boolean
}