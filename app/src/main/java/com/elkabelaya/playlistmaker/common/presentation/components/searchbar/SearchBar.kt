package com.elkabelaya.playlistmaker.common.presentation.components.searchbar

import android.content.res.Configuration
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.AppTheme
import com.elkabelaya.playlistmaker.common.presentation.Dimens
import com.elkabelaya.playlistmaker.common.presentation.utils.AppPreview

@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
    showClearButton: Boolean,
    onClearClicked: () -> Unit
) {
    Column {
    BasicTextField(//can set custom contentPadding only in BasicTextField
        value = query,
        onValueChange = onQueryChanged,
        cursorBrush = SolidColor(AppTheme.colors.accent),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                horizontal = Dimens.paddingM,
                vertical = Dimens.paddingXS
            )
            .onFocusChanged { focusState ->
                onFocusChanged(focusState.isFocused)
            },
        decorationBox = @Composable { innerTextField ->
           TextFieldDefaults.DecorationBox(
                value = query,
                visualTransformation = VisualTransformation.None,
                innerTextField = innerTextField,
                placeholder = { Text(text = stringResource(id = R.string.main_search)) },
                label = null,
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        tint = AppTheme.colors.hintSearch,
                        modifier = Modifier.size(Dimens.iconM)
                    )
                },
                trailingIcon = if (showClearButton) {
                    {
                        IconButton(
                            onClick = onClearClicked,

                            ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_close),
                                contentDescription = null,
                                tint = AppTheme.colors.hintSearch,
                                modifier = Modifier.size(Dimens.iconM)
                            )
                        }
                    }
                } else null,
                prefix = null,
                suffix = null,
                supportingText = null,
                shape = RoundedCornerShape(Dimens.radiusM),
                singleLine = true,
                enabled = true,
                isError = false,
                interactionSource = remember { MutableInteractionSource() },
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = AppTheme.colors.textSearch,
                    unfocusedTextColor = AppTheme.colors.textSearch,
                    focusedContainerColor = AppTheme.colors.backgroundSecondary,
                    unfocusedContainerColor = AppTheme.colors.backgroundSecondary,
                    cursorColor = AppTheme.colors.accent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLeadingIconColor = AppTheme.colors.hintSearch,
                    unfocusedLeadingIconColor = AppTheme.colors.hintSearch,
                    focusedTrailingIconColor = AppTheme.colors.hintSearch,
                    unfocusedTrailingIconColor = AppTheme.colors.hintSearch,
                    focusedPlaceholderColor = AppTheme.colors.hintSearch,
                    unfocusedPlaceholderColor = AppTheme.colors.hintSearch,
                ),
            )
        },
    )

}
}

@AppPreview
@Composable
fun SearchScreenPreview() {
    Column {
        SearchBar(
            query = "124",
            onQueryChanged = {},
            onFocusChanged = {},
            showClearButton = true,
            onClearClicked = { }
        )

        SearchBar(
            query = "",
            onQueryChanged = {},
            onFocusChanged = {},
            showClearButton = false,
            onClearClicked = {}
        )
    }
}