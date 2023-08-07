//package com.dmm.bootcamp.yatter2023.ui.profile
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.CircularProgressIndicator
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.FabPosition
//import androidx.compose.material.FloatingActionButton
//import androidx.compose.material.Icon
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.material.TopAppBar
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.material.pullrefresh.PullRefreshIndicator
//import androidx.compose.material.pullrefresh.pullRefresh
//import androidx.compose.material.pullrefresh.rememberPullRefreshState
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.dmm.bootcamp.yatter2023.ui.theme.Orange
//import com.dmm.bootcamp.yatter2023.ui.theme.White
//import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
//import com.dmm.bootcamp.yatter2023.ui.timeline.StatusRow
//import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.StatusBindingModel
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun ProfileTemplate(
//    statusList: List<StatusBindingModel>,
//    isLoading: Boolean,
//    isRefreshing: Boolean,
//    onRefresh: () -> Unit, //スワイプリロードのトリガー
//    onClickPost: () -> Unit, // 追加分
//) {
//    val pullRefreshState = rememberPullRefreshState(isRefreshing, onRefresh)
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "プロフィール", color = White)
//                },
//                backgroundColor = Orange //背景色変更
//            )
//        },
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(it) //これがないとScaffoldがエラーになる
//                .pullRefresh(pullRefreshState),
//            contentAlignment = Alignment.Center,
//        ) {
//            LazyColumn(
//                modifier = Modifier.fillMaxSize(),
//                contentPadding = PaddingValues(8.dp),
//            )
//            {
//                items(statusList) { item ->
//                    StatusRow(statusBindingModel = item)
//                }
//            }
//            PullRefreshIndicator(
//                isRefreshing,
//                pullRefreshState,
//                Modifier.align(Alignment.TopCenter)
//            )
//            if (isLoading) {
//                CircularProgressIndicator()
//            }
//        }
//    }
//}
//
//
//@Preview
//@Composable
//fun ProfileTPreview() {
//    Yatter2023Theme {
//        Surface{
//            ProfileTemplate(
//
//                statusList = listOf(
//                    StatusBindingModel(
//                        id = "id",
//                        displayName = "display name",
//                        username = "username",
//                        avatar = null,
//                        content = "preview content",
//                        attachmentMediaList = listOf()
//                    )
//                ),
//
//                isLoading = true,
//                isRefreshing = false,
//                onRefresh = {},
//                onClickPost = {}, // 追加分
//            )
//        }
//    }
//}