package ru.agladkov.delizioso.ui.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import ru.agladkov.delizioso.navigation.NavigationTree

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = Unit, block = {
        navController.navigate(NavigationTree.Login.name)
    })
}