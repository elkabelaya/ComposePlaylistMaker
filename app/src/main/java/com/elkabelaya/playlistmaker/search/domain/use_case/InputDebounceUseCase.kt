package com.elkabelaya.playlistmaker.search.domain.use_case

interface InputDebounceUseCase {
    fun debounce(callBack:() -> Unit)
    fun cancel()
}