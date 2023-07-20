package com.vipulasri.jetinstagram.ui.profile.tabs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.vipulasri.jetinstagram.data.PostsRepository
import com.vipulasri.jetinstagram.model.Post
import com.vipulasri.jetinstagram.model.currentUser
import com.vipulasri.jetinstagram.ui.components.UserPostView

@ExperimentalFoundationApi
@Composable
fun UserPosts() {
    val posts by PostsRepository.posts

    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        itemsIndexed(posts/*.filter { it.user.username == currentUser.username }*/) { _, post ->
            com.vipulasri.jetinstagram.ui.profile.tabs.Post(
                post = post,
                onClick = {},
                onLongPress = {}
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
private fun Post(
    post: Post,
    onClick: (Post) -> Unit,
    onLongPress: (Post) -> Unit
) {
    UserPostView(post = post, onClick = onClick, onLongPress = onLongPress)
}