package com.elkabelaya.playlistmaker.search.domain.impl

import com.elkabelaya.playlistmaker.common.domain.repository.LoopRepository
import com.elkabelaya.playlistmaker.search.domain.use_case.InputDebounceUseCase

open class InputDebounceUseCaseImpl(val loopRepository: LoopRepository): InputDebounceUseCase {
   override fun debounce(callBack:() -> Unit) {
       cancel()
        loopRepository.post(callBack, INPUT_DEBOUNCE_DELAY)
    }

    override fun cancel() {
        loopRepository.clear()
    }

    companion object {
        private const val INPUT_DEBOUNCE_DELAY = 2000L
    }
}