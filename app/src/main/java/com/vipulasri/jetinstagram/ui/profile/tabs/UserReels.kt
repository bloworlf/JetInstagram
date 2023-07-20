package com.vipulasri.jetinstagram.ui.profile.tabs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import com.vipulasri.jetinstagram.data.ReelsRepository
import com.vipulasri.jetinstagram.model.Post
import com.vipulasri.jetinstagram.model.Reel
import com.vipulasri.jetinstagram.model.currentUser
import com.vipulasri.jetinstagram.ui.components.UserPostView

@ExperimentalFoundationApi
@Composable
fun UserReels() {
    val reels = ReelsRepository.getReels()

    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        itemsIndexed(reels.filter { it.user.username == currentUser.username }) { _, reel ->
            Reel(
                reel = reel,
                onClick = {},
                onLongPress = {}
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
private fun Reel(
    reel: Reel,
    onClick: (Reel) -> Unit,
    onLongPress: (Reel) -> Unit
) {
    UserReelView(reel = reel, onClick = onClick, onLongPress = onLongPress)
}

@Composable
fun UserReelView(reel: Reel, onClick: (Reel) -> Unit, onLongPress: (Reel) -> Unit) {
    TODO("Not yet implemented")
}
