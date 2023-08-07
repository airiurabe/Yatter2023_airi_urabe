//package com.dmm.bootcamp.yatter2023.ui.profile
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.dmm.bootcamp.yatter2023.domain.model.Username
//import com.dmm.bootcamp.yatter2023.domain.repository.AccountRepository
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.update
//import kotlinx.coroutines.launch
//
//class ProfileViewModel(
//    private val accountRepository: AccountRepository, //依存関係を設定
//): ViewModel(){
//
//    private val _uiState: MutableStateFlow<ProfileUiState> =
//        MutableStateFlow(ProfileUiState.empty())
//    val uiState: StateFlow<ProfileUiState> = _uiState
//
//    private suspend fun fetchProfile() {
//        val username = intent?.getStringExtra("data")
//        val account = accountRepository.findByUsername(username = Username) //todo
//    }
//
//    fun onResume(username: String) {
//        viewModelScope.launch {
//            _uiState.update { it.copy(isLoading = true) }
//            fetchProfile()
//            _uiState.update { it.copy(isLoading = false) }
//        }
//    } //最初の読み込み
//}