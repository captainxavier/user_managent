package com.ivaxtech.usermanagement.presentation.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ivaxtech.usermanagement.domain.user.User
import com.ivaxtech.usermanagement.presentation.components.LoadingUserCard
import com.ivaxtech.usermanagement.presentation.components.UserCard
import com.ivaxtech.usermanagement.presentation.view_model.UserViewModel
import com.ivaxtech.usermanagement.ui.theme.Teal200

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {

    val viewModel = hiltViewModel<UserViewModel>()
    val users by viewModel.users.observeAsState(arrayListOf())
    val isLoading by viewModel.isLoading.observeAsState(false)

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp)
                    .height(50.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Home", style = MaterialTheme.typography.h6)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.addUser() },
                contentColor = Teal200,
                backgroundColor = MaterialTheme.colors.surface,
            ) {
                Icon(Icons.Filled.Add, "")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { contentPadding ->
        // Screen content
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            LazyColumn {
                var itemCount = users.size
                if (isLoading) itemCount++

                items(count = itemCount) { index ->
                    var auxIndex = index;
                    val dismissState = rememberDismissState()


                    if (isLoading) {
                        return@items LoadingUserCard()
                        auxIndex--
                    }
                    val user = users[auxIndex]


                    if (dismissState.isDismissed(DismissDirection.EndToStart)) {

                        viewModel.deleteUser(user)
                    }

                    SwipeToDismiss(
                        state = dismissState,
                        modifier = Modifier
                            .padding(vertical = Dp(1f)),
                        directions = setOf(
                            DismissDirection.EndToStart
                        ),
                        dismissThresholds = { direction ->
                            FractionalThreshold(if (direction == DismissDirection.EndToStart) 0.1f else 0.05f)
                        },
                        background = {
                            val color by animateColorAsState(
                                when (dismissState.targetValue) {
                                    DismissValue.Default -> Color.White
                                    else -> Color.Red
                                }
                            )
                            val alignment = Alignment.CenterEnd
                            val icon = Icons.Default.Delete

                            val scale by animateFloatAsState(
                                if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f
                            )

                            Box(
                                Modifier
                                    .fillMaxSize()
                                    .background(color)
                                    .padding(horizontal = Dp(20f)),
                                contentAlignment = alignment
                            ) {
                                Icon(
                                    icon,
                                    contentDescription = "Delete Icon",
                                    modifier = Modifier.scale(scale)
                                )
                            }
                        },
                        dismissContent = {

                            UserCard(user = user)
                        }
                    )
                }


            }
        }
    }

}