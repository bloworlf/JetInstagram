package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.ui.components.diagonalGradientBorder

@OptIn(ExperimentalCoilApi::class)
@ExperimentalFoundationApi
@Composable
fun UserDP(imageUrl: String) {
    val shape = CircleShape
    Box(
        modifier = Modifier
            .diagonalGradientBorder(
                colors = listOf(
                    Color(0xFFd71069),
                    Color(0xFFe25d6a),
                    Color(0xFFe9ad55),
                ),
                shape = shape,
                isFromRight = true
            )
    ) {
        Image(
            painter = rememberImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            //        contentTint = MaterialTheme.colors.onSurface
        )
    }
}