package com.dmm.bootcamp.yatter2023.ui.timeline

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

//ViewModelから状態を取り出し、Templateコンポーザブルに渡す
@Composable
fun PublicTimelinePage(viewModel: PublicTimelineViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//uiState更新を反映する
    PublicTimelineTemplate(
        statusList = uiState.statusList,
        isLoading = uiState.isLoading,
        isRefreshing = uiState.isRefreshing,
        onRefresh = viewModel::onRefresh, //onRefreshはViewModelのメソッドだから関数オブジェクトとして渡す
        onClickPost = viewModel::onClickPost, // 追加分
    )
}
//ここではUIを実装しないのでPreview略