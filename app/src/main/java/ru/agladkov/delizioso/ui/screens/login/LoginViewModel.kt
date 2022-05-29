package ru.agladkov.delizioso.ui.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.agladkov.delizioso.common.EventHandler
import ru.agladkov.delizioso.ui.screens.login.models.LoginAction
import ru.agladkov.delizioso.ui.screens.login.models.LoginEvent
import ru.agladkov.delizioso.ui.screens.login.models.LoginSubState
import ru.agladkov.delizioso.ui.screens.login.models.LoginViewState
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel(), EventHandler<LoginEvent> {

    private val _viewState = MutableLiveData(LoginViewState())
    val viewState: LiveData<LoginViewState> = _viewState

    override fun obtainEvent(event: LoginEvent) {
        when (event) {
            LoginEvent.LoginActionInvoked -> loginActionInvoked()
            LoginEvent.ActionClicked -> switchActionState()
            is LoginEvent.EmailChanged -> emailChanged(event.value)
            is LoginEvent.PasswordChanged -> passwordChanged(event.value)
            is LoginEvent.ForgetClicked -> forgetClicked()
            is LoginEvent.CheckboxClicked -> checkboxClicked(event.value)
            is LoginEvent.LoginClicked -> loginClicked()
        }
    }

    private fun switchActionState() {
        when (_viewState.value?.loginSubState) {
            LoginSubState.SignIn -> _viewState.postValue(_viewState.value?.copy(loginSubState = LoginSubState.SignUp))
            LoginSubState.SignUp -> _viewState.postValue(_viewState.value?.copy(loginSubState = LoginSubState.SignIn))
        }
    }

    private fun loginClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            _viewState.postValue(_viewState.value?.copy(isProgress = true))
            delay(3000)
            _viewState.postValue(
                _viewState.value?.copy(
                    isProgress = false,
                    loginAction = LoginAction.OpenDashboard("Mobile Developer")
                )
            )
        }
    }

    private fun loginActionInvoked() {
        _viewState.postValue(_viewState.value?.copy(loginAction = LoginAction.None))
    }

    private fun checkboxClicked(value: Boolean) {
        _viewState.postValue(_viewState.value?.copy(rememberMeChecked = value))
    }

    private fun forgetClicked() {
        _viewState.postValue(_viewState.value?.copy(loginSubState = LoginSubState.Forgot))
    }

    private fun emailChanged(value: String) {
        _viewState.postValue(_viewState.value?.copy(emailValue = value))
    }

    private fun passwordChanged(value: String) {
        _viewState.postValue(_viewState.value?.copy(passwordValue = value))
    }
}