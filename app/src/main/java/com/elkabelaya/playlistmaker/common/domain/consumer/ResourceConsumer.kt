package com.elkabelaya.playlistmaker.common.domain.consumer

import com.elkabelaya.playlistmaker.common.domain.model.Resource

interface ResourceConsumer<T> {
    fun consume(resource: Resource<T>)
}