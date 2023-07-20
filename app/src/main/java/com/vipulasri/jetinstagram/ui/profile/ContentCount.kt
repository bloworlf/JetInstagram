package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder.TextAlignment
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10

@ExperimentalFoundationApi
@Composable
fun ContentCount(
    count: Int,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = prettyCount(count),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2
        )
    }
}

private fun prettyCount(number: Number): String {
    val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
    val numValue = number.toLong()
    val value = floor(log10(numValue.toDouble())).toInt()
    val base = value / 3
    return if (value >= 3 && base < suffix.size) {
        DecimalFormat("#0.0").format(
            numValue / Math.pow(
                10.0,
                (base * 3).toDouble()
            )
        ) + suffix[base]
    } else {
        DecimalFormat("#,##0").format(numValue)
    }
}