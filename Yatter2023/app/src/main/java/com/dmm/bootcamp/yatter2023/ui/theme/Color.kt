package com.dmm.bootcamp.yatter2023.ui.theme

import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Orange = Color(0XFFF8955B)
val LightGreen = Color(0xFF00B0AA)
val White = Color(0xFFFFFFFF)

@Composable
fun defaultButtonColors() = ButtonDefaults.buttonColors(
    backgroundColor = LightGreen, //ボタン背景色
    contentColor = White, // ボタンのテキスト色
    disabledBackgroundColor = LightGreen.copy(alpha = ContentAlpha.disabled),
    disabledContentColor = White.copy(alpha = ContentAlpha.disabled)
)