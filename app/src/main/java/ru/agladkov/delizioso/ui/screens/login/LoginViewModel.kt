package ru.agladkov.delizioso.ui.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.agladkov.delizioso.common.EventHandler
import ru.agladkov.delizioso.ui.screens.login.models.LoginEvent
import ru.agladkov.delizioso.ui.screens.login.models.LoginSubState
import ru.agladkov.delizioso.ui.screens.login.models.LoginViewState
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel(), EventHandler<LoginEvent> {

    private val _viewState = MutableLiveData(LoginViewState())
    val viewState: LiveData<LoginViewState> = _viewState

    override fun obtainEvent(event: LoginEvent) {
        when (event) {
            LoginEvent.ActionClicked -> switchActionState()
            is LoginEvent.EmailChanged -> emailChanged(event.value)
        }
    }

    private fun switchActionState() {
        when(_viewState.value?.loginSubState) {
            LoginSubState.SignIn -> _viewState.postValue(_viewState.value?.copy(loginSubState = LoginSubState.SignUp))
            LoginSubState.SignUp -> _viewState.postValue(_viewState.value?.copy(loginSubState = LoginSubState.SignIn))
        }
    }

    private fun emailChanged(value: String) {
        _viewState.postValue(_viewState.value?.copy(emailValue = value))
    }
}