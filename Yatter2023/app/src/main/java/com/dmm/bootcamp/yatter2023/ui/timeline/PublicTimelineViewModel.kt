package com.dmm.bootcamp.yatter2023.ui.timeline

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2023.domain.repository.StatusRepository
import com.dmm.bootcamp.yatter2023.ui.timeline.converter.StatusConverter
import com.dmm.bootcamp.yatter2023.util.SingleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PublicTimelineViewModel(
    private val statusRepository: StatusRepository, //Statusの一覧を取得するためにStatusRepositoryを依存関係に追加
): ViewModel() {
    private val _navigateToPost: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToPost: LiveData<Unit> = _navigateToPost

    private val _uiState: MutableStateFlow<PublicTimelineUiState> =
        MutableStateFlow(PublicTimelineUiState.empty())
    val uiState: StateFlow<PublicTimelineUiState> = _uiState //外部には公開できないもの（=StateFlow）を見せる

    private suspend fun fetchPublicTimeline() {
        val statusList = statusRepository.findAllPublic() // StatusRepositoryからStatus一覧を取得
        _uiState.update {
            it.copy(
                statusList = StatusConverter.convertToBindingModel(statusList), // PublicTimeline内のstatusListを更新
            )
        }
    }

    fun onResume() {
        viewModelScope.launch { // 1
            _uiState.update { it.copy(isLoading = true) } // 2
            fetchPublicTimeline() // 3
            _uiState.update { it.copy(isLoading = false) } // 4
        }
    } //最初の読み込み

    fun onRefresh() {
        viewModelScope.launch { // 1
            _uiState.update { it.copy(isRefreshing = true) } // 2
            fetchPublicTimeline() // 3
            _uiState.update { it.copy(isRefreshing = false) } // 4
        }
    } //スワイプで更新

    fun onClickPost() {
        _navigateToPost.value = Unit
    }
}