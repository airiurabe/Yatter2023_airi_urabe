//package com.dmm.bootcamp.yatter2023.ui.profile
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//
////ViewModelから状態を取り出し、Templateコンポーザブルに渡す
//@Composable
//fun ProfilePage(viewModel: ProfileViewModel) {
//
//    val userProfile by viewModel.userProfile.collectAsState()
//
//    ProfileTemplate(
//
//        isLoading = uiState.isLoading,
//        isRefreshing = uiState.isRefreshing,
//        onRefresh = viewModel::onRefresh,
//    )
//    }
//
//    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//
//    ProfileTemplate(
//    statusList = uiState.statusList,
//    isLoading = uiState.isLoading,
//    isRefreshing = uiState.isRefreshing,
//    onRefresh = viewModel::onRefresh, //onRefreshはViewModelのメソッドだから関数オブジェクトとして渡す
//    onClickPost = viewModel::onClickPost, // 追加分
//    )
//}