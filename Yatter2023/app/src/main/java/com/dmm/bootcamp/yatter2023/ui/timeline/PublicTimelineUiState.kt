package com.dmm.bootcamp.yatter2023.ui.timeline

import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.StatusBindingModel

data class PublicTimelineUiState(
    val statusList: List<StatusBindingModel>,
    val isLoading: Boolean, //trueかfalseを返す
    val isRefreshing: Boolean,
){
    companion object {
        fun empty(): PublicTimelineUiState = PublicTimelineUiState( //UiStateには初期値が必要
            statusList = emptyList(),
            isLoading = false,
            isRefreshing = false,
        )
    }
}