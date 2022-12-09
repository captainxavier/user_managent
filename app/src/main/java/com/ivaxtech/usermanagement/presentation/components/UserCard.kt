package com.ivaxtech.usermanagement.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.ivaxtech.usermanagement.domain.user.User
import com.valentinilk.shimmer.shimmer

@Composable
fun UserCard(
    user: User
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp)
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                val painter =
                    rememberImagePainter(data = user.thumbnail,
                        builder = {
                            transformations(
                                CircleCropTransformation()       // Circle Crop Transformation
                            )
                        })

                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier) {
                    val name = "${user.name} ${user.lastName}"
                    Text(text = name, style = MaterialTheme.typography.subtitle2)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = user.city, style = MaterialTheme.typography.caption)
                }

            }


        }

    }

}

