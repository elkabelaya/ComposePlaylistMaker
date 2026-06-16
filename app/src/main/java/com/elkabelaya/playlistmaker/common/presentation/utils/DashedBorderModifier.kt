package com.elkabelaya.playlistmaker.common.presentation.utils

import android.annotation.SuppressLint
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.dashedBorder(
    width: Dp,
    color: Color,
    dashLength: Dp = 10.dp,
    gapLength: Dp = 10.dp,
    cornerRadius: Dp = 0.dp
): Modifier = drawWithCache {
    onDrawBehind {
        val strokeWidthPx = width.toPx()
        val dashLengthPx = dashLength.toPx()
        val gapLengthPx = gapLength.toPx()
        val cornerRadiusPx = cornerRadius.toPx()

        val stroke = Stroke(
            width = strokeWidthPx,
            pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(dashLengthPx, gapLengthPx),
                phase = 0f
            )
        )

        drawRoundRect(
            color = color,
            style = stroke,
            cornerRadius = CornerRadius(cornerRadiusPx)
        )
    }
}