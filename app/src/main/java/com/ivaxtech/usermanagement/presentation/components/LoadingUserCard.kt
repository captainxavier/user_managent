package com.ivaxtech.usermanagement.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun LoadingUserCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp)
            .testTag("loadingCard"),
        elevation = 8.dp
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

                ImageLoading()
                Spacer()
                Column {
                    Spacer()
                    Box(modifier = Modifier.shimmer()) {
                        Column {
                            Box(
                                modifier = Modifier
                                    .height(6.dp)
                                    .fillMaxWidth()
                                    .background(Color.Gray)
                            )
                            Spacer()
                            Box(
                                modifier = Modifier
                                    .height(6.dp)
                                    .fillMaxWidth()
                                    .background(Color.Gray)
                            )
                        }
                    }
                }


            }


        }

    }

}

@Composable
fun ImageLoading() {
    Box(modifier = Modifier.shimmer()) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Gray)
        )
    }
}

@Composable
fun Spacer(size: Int = 10) = Spacer(modifier = Modifier.size(size.dp))