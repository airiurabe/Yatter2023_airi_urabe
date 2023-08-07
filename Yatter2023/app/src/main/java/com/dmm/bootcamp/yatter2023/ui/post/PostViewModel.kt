package com.dmm.bootcamp.yatter2023.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2023.domain.service.GetMeService
import com.dmm.bootcamp.yatter2023.usecase.post.PostStatusUseCase
import com.dmm.bootcamp.yatter2023.usecase.post.PostStatusUseCaseResult
import com.dmm.bootcamp.yatter2023.util.SingleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PostViewModel(
    private val postStatusUseCase: PostStatusUseCase,
    private val getMeService: GetMeService,
) : ViewModel() {
    private val _uiState: MutableStateFlow<PostUiState> = MutableStateFlow(PostUiState.empty())
    val uiState: StateFlow<PostUiState> = _uiState

    private val _goBack: SingleLiveEvent<Unit> = SingleLiveEvent()
    val goBack: LiveData<Unit> = _goBack

    fun onCreate() { //ログイン済みのユーザーを取得し、必要なアバター画像の情報のみをUiStateに更新
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val me = getMeService.execute()

            val snapshotBindingModel = uiState.value.bindingModel
            _uiState.update {
                it.copy(
                    bindingModel = snapshotBindingModel.copy(avatarUrl = me?.avatar.toString()),
                    isLoading = false,
                )
            }
        }
    }

    fun onChangedStatusText(statusText: String) { //入力された文字列にUiStateを更新する
        _uiState.update { it.copy(bindingModel = uiState.value.bindingModel.copy(statusText = statusText)) }
    }

    fun onClickPost() { //投稿用のボタン押下時の挙動、ローディング表示を行い、投稿完了したら画面を戻る
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val result = postStatusUseCase.execute(
                content = uiState.value.bindingModel.statusText,
                attachmentList = listOf()
            )
            when (result) {
                PostStatusUseCaseResult.Success -> {
                    _goBack.value = Unit
                }

                is PostStatusUseCaseResult.Failure -> {
                    // エラー表示
                }
            }
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    fun onClickNavIcon() { //戻る時
        _goBack.value = Unit
    }
}