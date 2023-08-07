package com.dmm.bootcamp.yatter2023.ui.timeline

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import com.dmm.bootcamp.yatter2023.ui.post.PostActivity
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import org.koin.androidx.viewmodel.ext.android.viewModel

class PublicTimelineActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent = Intent(
            context,
            PublicTimelineActivity::class.java,
        ) //画面遷移するときはこう書くことが多い、違うやり方は講義資料に
    }

    private val viewModel: PublicTimelineViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { //ActivityとPageコンポーザブルを繋ぐ
            Yatter2023Theme { //アプリ全体のUIのテーマを指定
                Surface {
                    PublicTimelinePage(viewModel = viewModel)
                }
            }
        }

        viewModel.navigateToPost.observe(this) {
            startActivity(PostActivity.newIntent(this))
        } //ツイート画面へ遷移
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    } //onResumeが呼び出されるとき（画面を表示するたび）にViewModel#onResumeを呼び出しデータを更新する
}