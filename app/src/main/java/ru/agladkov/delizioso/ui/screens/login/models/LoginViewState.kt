package ru.agladkov.delizioso.ui.screens.login.models

enum class LoginSubState {
    SignIn, SignUp, Forgot
}

data class LoginViewState(
    val loginSubState: LoginSubState = LoginSubState.SignIn,
    val emailValue: String = "",
    val passwordValue: String = "",
    val fullNameValue: String = "",
    val rememberMeChecked: Boolean = false,
    val isLoginProgress: Boolean = false
)