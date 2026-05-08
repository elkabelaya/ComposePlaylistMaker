package com.elkabelaya.playlistmaker.common.domain.repository
import com.elkabelaya.playlistmaker.common.domain.model.Email

interface ExternalNavigatorRepository {
    fun share(data: String)
    fun openWeb(link: String)
    fun openEmail(email: Email)
}