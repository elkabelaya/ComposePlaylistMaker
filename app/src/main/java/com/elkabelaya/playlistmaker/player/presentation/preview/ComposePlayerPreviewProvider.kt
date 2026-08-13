package com.elkabelaya.playlistmaker.player.presentation.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.elkabelaya.playlistmaker.common.domain.mocks.mock1
import com.elkabelaya.playlistmaker.common.domain.mocks.mock2
import com.elkabelaya.playlistmaker.common.domain.mocks.mock3
import com.elkabelaya.playlistmaker.common.domain.mocks.mock4
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.player.domain.model.PlayerState
import com.elkabelaya.playlistmaker.player.presentation.PlayerViewModel


class ComposePlayerPreviewProvider() : PreviewParameterProvider<PlayerViewModel> {
    override val values = sequenceOf(
        PlayerViewModelMock(Track.mock1(), PlayerState.Default("00:00")),
        PlayerViewModelMock(Track.mock2(),PlayerState.Playing("00:10"), isFavorite = true),
        PlayerViewModelMock(Track.mock3(),PlayerState.Paused("00:10")),
        PlayerViewModelMock(Track.mock4(),PlayerState.Prepared("00:00")),
    )
}
