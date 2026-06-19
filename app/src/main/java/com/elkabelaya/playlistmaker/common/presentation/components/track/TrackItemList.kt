package com.elkabelaya.playlistmaker.common.presentation.components.track

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elkabelaya.playlistmaker.common.domain.model.Track
import com.elkabelaya.playlistmaker.common.presentation.Dimens
import com.elkabelaya.playlistmaker.common.domain.mocks.mockList
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview

@Composable
fun TrackItemList(
    items: List<Track>,
    onClick: (Track) -> Unit,
    onLongClick: ((Track) -> Unit)? = null
) {
    LazyColumn(modifier = Modifier.padding(top = Dimens.paddingM)) {
        items(items) { item ->
            TrackItem(item, onClick, onLongClick)
        }
    }
}

@AppPreview
@Composable
fun TrackItemListPreview() {
    TrackItemList(Track.mockList(),{})
}