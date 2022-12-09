package com.ivaxtech.usermanagement.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ivaxtech.usermanagement.R

// Set of Material typography styles to start with
val LATO = FontFamily(
    Font(R.font.lato_thin, FontWeight.Thin),
    Font(R.font.lato_light, FontWeight.Light),
    Font(R.font.lato_regular, FontWeight.Normal),
    Font(R.font.lato_bold, FontWeight.Bold),
    Font(R.font.lato_black, FontWeight.Black)
)


val Typography = Typography(

    h1 = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.Black,
        fontSize = 96.sp
    ),
    h2 = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.Bold,
        fontSize = 60.sp
    ),
    h3 = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp
    ),
    h4 = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),
    h5 = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),

    h6 = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),

    button = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),

    body1 = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    body2 = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    caption = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    overline = TextStyle(
        fontFamily = LATO,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    )