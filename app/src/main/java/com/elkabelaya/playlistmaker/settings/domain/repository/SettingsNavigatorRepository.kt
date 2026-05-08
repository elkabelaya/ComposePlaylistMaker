package com.elkabelaya.playlistmaker.settings.domain.repository

import com.elkabelaya.playlistmaker.common.domain.model.Email

interface SettingsNavigatorRepository {
    fun getShareUrl(): String
    fun getEmail(): Email
    fun getAgreementUrl(): String
}