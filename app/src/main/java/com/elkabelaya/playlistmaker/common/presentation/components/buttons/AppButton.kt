package com.elkabelaya.playlistmaker.common.presentation.components.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.elkabelaya.playlistmaker.R
import com.elkabelaya.playlistmaker.common.presentation.Dimens
import com.elkabelaya.playlistmaker.common.presentation.appFontFamily

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = buttonColors(
            containerColor = colorResource(id = R.color.yp_blue),
            contentColor = colorResource(id = R.color.yp_white),
            disabledContainerColor = colorResource(id = R.color.yp_text_gray),
            disabledContentColor = colorResource(id = R.color.yp_white),
        ),
        shape = RoundedCornerShape(
            dimensionResource(id = R.dimen.radius_xs)
        ),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Color.White,
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize   = Dimens.textM
            ),
            maxLines = 1,

        )
    }
}

@Preview
@Composable
fun AppButtonPreview() {
    Column {
        AppButton("Some text", {})
        AppButton("Some text", {}, enabled = false)
    }

}