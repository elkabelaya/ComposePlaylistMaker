package com.elkabelaya.playlistmaker.common.data.repository

import com.elkabelaya.playlistmaker.common.domain.repository.LoopRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesLoopRepositoryImpl(): LoopRepository {
    var scope: CoroutineScope? = null

    override fun post(call: () -> Unit, delay: Long) {
        scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        scope?.launch {
            delay(delay)
            call()
        }
    }

    override fun clear() {
        scope?.cancel()
    }
}