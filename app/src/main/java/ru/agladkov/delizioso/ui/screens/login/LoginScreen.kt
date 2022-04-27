package ru.agladkov.delizioso.ui.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.agladkov.delizioso.R
import ru.agladkov.delizioso.ui.screens.login.models.LoginEvent
import ru.agladkov.delizioso.ui.screens.login.models.LoginSubState
import ru.agladkov.delizioso.ui.screens.login.models.LoginViewState
import ru.agladkov.delizioso.ui.screens.login.views.ForgotView
import ru.agladkov.delizioso.ui.screens.login.views.SignInView
import ru.agladkov.delizioso.ui.screens.login.views.SignUpView
import ru.agladkov.delizioso.ui.theme.AppTheme

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel
) {
    val viewState = loginViewModel.viewState.observeAsState(LoginViewState())

    with(viewState.value) {
        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            item {
                Text(
                    modifier = Modifier.padding(top = 32.dp),
                    text = when (loginSubState) {
                        LoginSubState.SignIn -> stringResource(id = R.string.sign_in_title)
                        LoginSubState.SignUp -> stringResource(id = R.string.sign_up_title)
                        LoginSubState.Forgot -> stringResource(id = R.string.forgot_title)
                    },
                    style = TextStyle(
                        color = AppTheme.colors.headerTextColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 50.sp
                    )
                )
            }

            item {
                Row(modifier = Modifier.padding(top = 17.dp)) {
                    Text(
                        text = when (loginSubState) {
                            LoginSubState.SignIn -> stringResource(id = R.string.sign_in_subtitle)
                            LoginSubState.SignUp -> stringResource(id = R.string.sign_up_subtitle)
                            LoginSubState.Forgot -> stringResource(id = R.string.forgot_subtitle)
                        }, style = TextStyle(
                            color = AppTheme.colors.primaryTextColor
                        )
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    if (loginSubState != LoginSubState.Forgot) {
                        Text(
                            modifier = Modifier.clickable {
                                loginViewModel.obtainEvent(LoginEvent.ActionClicked)
                            },
                            text = when (loginSubState) {
                                LoginSubState.SignIn -> stringResource(id = R.string.sign_in_action)
                                LoginSubState.SignUp -> stringResource(id = R.string.sign_up_action)
                                else -> ""
                            },
                            style = TextStyle(
                                color = AppTheme.colors.actionTextColor,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }
            }

            item {
                when (loginSubState) {
                    LoginSubState.SignIn -> SignInView(
                        viewState = this@with,
                        onTextFieldChange = {
                            loginViewModel.obtainEvent(LoginEvent.EmailChanged(it))
                        }
                    )
                    LoginSubState.SignUp -> SignUpView()
                    LoginSubState.Forgot -> ForgotView()
                }
            }
        }
    }
}