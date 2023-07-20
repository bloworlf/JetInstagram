package com.vipulasri.jetinstagram.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.vipulasri.jetinstagram.model.Reel

@ExperimentalFoundationApi
@Composable
fun UserReelView(
    reel: Reel,
    onClick: (Reel) -> Unit,
    onLongPress: (Reel) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(color = Color.LightGray)
    ) {
        VideoPlayer(uri = reel.getVideoUrl())
    }
}