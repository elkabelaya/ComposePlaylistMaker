package com.elkabelaya.playlistmaker.common.presentation.components

import android.content.res.Configuration
import android.graphics.PointF
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.AppTheme
import com.elkabelaya.playlistmaker.common.presentation.Dimens
import com.elkabelaya.playlistmaker.common.presentation.appFontFamily

@Composable
fun OutlinedInput(
    hint: String,
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
) {
    val strokeColor = colorResource(id = R.color.edit_text_box_stroke_colors)
    val cursorColor = colorResource(id = R.color.yp_blue)

    val editTextHeight = dimensionResource(id = R.dimen.edittext_height)

    val interactionSource = remember { MutableInteractionSource() }
    val focused = interactionSource.collectIsFocusedAsState().value
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        cursorBrush = SolidColor(AppTheme.colors.accent),
        modifier = modifier
            .fillMaxWidth()
            .height(editTextHeight),
        textStyle = TextStyle(
            color = colorResource(id = R.color.text_title),
            fontSize = Dimens.textM,
            fontFamily = appFontFamily,
            fontWeight = FontWeight.Normal,
        ),
        decorationBox = @Composable { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = value,
                visualTransformation = VisualTransformation.None,
                innerTextField = innerTextField,
                label = {
                    Text(
                        text = hint,
                        color = strokeColor,
                        fontSize = if (focused || value.isNotEmpty()) Dimens.textXS else Dimens.textM,
                        fontFamily = appFontFamily,
                        fontWeight = FontWeight.Normal,
                    )
                },
                singleLine = true,
                enabled = true,
                isError = false,
                interactionSource = interactionSource,
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 18.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = strokeColor,
                    unfocusedBorderColor = strokeColor,
                    cursorColor = cursorColor,
                )
            )
        },
    )
}

@Preview(name = "Light", showBackground = true)
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun OutlinedInputPreview () {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        OutlinedInput("label", "") {}
        OutlinedInput("label", "text1") {}
    }
}

