package com.elkabelaya.playlistmaker.common.data.model

data class NetworkResponse<T>(val data: T, val code: String)