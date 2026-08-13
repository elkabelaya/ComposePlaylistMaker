package com.elkabelaya.playlistmaker.player.domain.model

sealed class PlayerState(open val time: String) {
    data class Default(override val time: String): PlayerState(time)
    data class Prepared(override val time: String): PlayerState(time)
    data class Playing(override val time: String): PlayerState(time)
    data class Paused(override val time: String): PlayerState(time)
}