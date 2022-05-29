package ru.agladkov.delizioso.ui.screens.login.models

import androidx.compose.runtime.Stable

enum class LoginSubState {
    SignIn, SignUp, Forgot
}

sealed class LoginAction {
    data class OpenDashboard(val username: String) : LoginAction()
    object None : LoginAction()
}

@Stable
data class LoginViewState(
    val loginSubState: LoginSubState = LoginSubState.SignIn,
    val emailValue: String = "",
    val passwordValue: String = "",
    val fullNameValue: String = "",
    val rememberMeChecked: Boolean = false,
    val isProgress: Boolean = false,
    val isLoginPassed: Boolean = false,
    val loginAction: LoginAction = LoginAction.None
)

