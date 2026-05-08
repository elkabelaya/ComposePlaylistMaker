package com.elkabelaya.playlistmaker.settings.presentation.repository

import android.content.Context
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.domain.model.Email
import com.elkabelaya.playlistmaker.settings.domain.repository.SettingsNavigatorRepository

class SettingsNavigatorRepositoryImpl(val context: Context): SettingsNavigatorRepository {
    override fun getShareUrl(): String {
        return context.getString(R.string.settings_share_url)
    }

    override fun getEmail(): Email {
        return Email(
            context.getString( R.string.settings_support_email),
            context.getString(R.string.settings_support_subject),
            context.getString(R.string.settings_support_body)
        )
    }

    override fun getAgreementUrl(): String {
        return context.getString( R.string.settings_agreement_url)
    }
}