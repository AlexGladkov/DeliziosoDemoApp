package ru.agladkov.delizioso.ui.theme

import androidx.compose.ui.graphics.Color

data class Colors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val headerTextColor: Color,
    val primaryTextColor: Color,
    val primaryTextInvertColor: Color,
    val hintTextColor: Color,
    val primaryTintColor: Color,
    val secondaryTintColor: Color,
    val accentColor: Color,
    val notificationColor: Color,
    val actionTextColor: Color,
    val borderColor: Color,
    val hiddenColor: Color,
)

val lightPalette = Colors(
    primaryBackground = Color.White,
    secondaryBackground = Color(0x10D0CCC7),
    headerTextColor = Color(0xFF311F09),
    primaryTextColor = Color(0xFF59442B),
    primaryTextInvertColor = Color(0xFFFFFFFF),
    primaryTintColor = Color(0xFFFF8A00),
    secondaryTintColor = Color(0xFF3FA72F),
    hintTextColor = Color(0xFFA0978C),
    accentColor = Color(0xFF8AEAFF),
    notificationColor = Color(0xFFFF3838),
    actionTextColor = Color(0xFF0094FF),
    borderColor = Color(0xFFDCD4CB),
    hiddenColor = Color(0xFFC7BFB6)
)