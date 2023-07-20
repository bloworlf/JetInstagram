package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.PostsRepository
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.Post
import com.vipulasri.jetinstagram.model.Story
import com.vipulasri.jetinstagram.model.User
import com.vipulasri.jetinstagram.model.currentUser
import com.vipulasri.jetinstagram.ui.components.icon
import com.vipulasri.jetinstagram.ui.home.PostView
import com.vipulasri.jetinstagram.ui.home.StoryImage
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun Profile(title: String) {

    val coroutineScope = rememberCoroutineScope()
//val name = currentUser.
    Scaffold(
        topBar = { Toolbar(title) }) {
        val posts by PostsRepository.posts
        val stories by StoriesRepository.observeStories()

        Column {
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
//                StoryImage(imageUrl = "")
                UserDP(imageUrl = "")
                Spacer(modifier = Modifier.width(16.dp))
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                    Row(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ContentCount(count = 371, title = "Posts", modifier = Modifier.weight(1f))
//                        Spacer(modifier = Modifier.width(16.dp))
                        ContentCount(
                            count = 14400,
                            title = "Followers",
                            modifier = Modifier.weight(1f)
                        )
//                        Spacer(modifier = Modifier.width(16.dp))
                        ContentCount(
                            count = 272,
                            title = "Following",
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(Modifier.fillMaxWidth()) {
                        Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(9F)) {
                            Text(text = "Follow")
                        }
                        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(1F)) {
                            Icon(
                                painter = painterResource(id = R.drawable.more),
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = currentUser.username)
                Text(text = "website")
                Text(text = "website")
                Text(text = "website")
            }

            LazyColumn {
                item {
                    StoriesSection(stories.sortedBy { it.isSeen })
                    Divider()
                }
            }
            Box(
                modifier = Modifier.padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Directions",
                    color = Color.Blue,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            Divider()

            Box(
                modifier = Modifier.padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 64.dp, end = 64.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.category),
                        contentDescription = ""
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = ""
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = ""
                    )
                }
            }
            Divider()
            LazyVerticalGrid(cells = GridCells.Fixed(3)) {
                itemsIndexed(posts.filter { it.user.username == currentUser.username }) { _, post ->
                    Post(post,
                        onClick = {
//                            coroutineScope.launch {
//                                PostsRepository.performLike(post.id)
//                            }
                        },
                        onLongPress = {
//                            coroutineScope.launch {
//                                PostsRepository.toggleLike(post.id)
//                            }
                        }
                    )


                }
            }
        }
    }
}

@Composable
private fun Toolbar(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_back),
            modifier = Modifier.icon(),
            contentDescription = ""
        )
        Box(
            modifier = Modifier.padding(6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = title, style = MaterialTheme.typography.h4)
        }
        Icon(
            painter = painterResource(id = R.drawable.more),
            modifier = Modifier.icon(),
            contentDescription = ""
        )
    }
}

@Composable
private fun StoriesSection(stories: List<Story>) {
    Column {
        StoriesList(stories)
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun StoriesList(stories: List<Story>) {
    LazyRow {
        itemsIndexed(stories) { index, story ->

            if (index == 0) {
                Spacer(modifier = Modifier.width(6.dp))
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 6.dp)
            ) {
                StoryImage(imageUrl = story.image)
                Spacer(modifier = Modifier.height(5.dp))
                Text(story.name, style = MaterialTheme.typography.caption)
            }

            if (index == stories.size.minus(1)) {
                Spacer(modifier = Modifier.width(6.dp))
            }
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

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun PreviewProfile() {
    Profile(title = "username")
}