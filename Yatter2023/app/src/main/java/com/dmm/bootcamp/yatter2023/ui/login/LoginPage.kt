package com.dmm.bootcamp.yatter2023.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme

@Composable
fun LoginPage(viewModel: LoginViewModel) {
    val uiState: LoginUiState by viewModel.uiState.collectAsStateWithLifecycle()

    LoginTemplate(
        userName = uiState.loginBindingModel.username,
        onChangedUserName = viewModel::onChangedUsername,
        password = uiState.loginBindingModel.password,
        onChangedPassword = viewModel::onChangedPassword,
        isEnableLogin = uiState.isEnableLogin,
        isLoading = uiState.isLoading,
        onClickLogin = viewModel::onClickLogin,
        onClickRegister = viewModel::onClickRegister,
    )

    class LoginActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContent {
                Yatter2023Theme {
                    Surface {
                        LoginPage(viewModel = viewModel)
                    }
                }
            }
        }
    }
}