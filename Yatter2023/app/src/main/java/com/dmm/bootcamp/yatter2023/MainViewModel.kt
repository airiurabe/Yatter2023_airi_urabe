package com.dmm.bootcamp.yatter2023

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2023.domain.service.CheckLoginService
import com.dmm.bootcamp.yatter2023.util.SingleLiveEvent
import kotlinx.coroutines.launch

class MainViewModel(
    //外部から与えられる

    private val checkLoginService: CheckLoginService,

    ) : ViewModel() { //内部で規定する

    private val _navigateToLogin: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToLogin: LiveData<Unit> = _navigateToLogin
    private val _navigateToPublicTimeline: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToPublicTimeline: LiveData<Unit> = _navigateToPublicTimeline
  fun onCreate() {
    viewModelScope.launch {
      if (checkLoginService.execute()) {
        //checkLoginが成功した時
        Log.d("test", "sucess")
        _navigateToPublicTimeline.value = Unit
      } else {
        //checkLoginが失敗した時
        Log.d("test", "fail")
        _navigateToLogin.value = Unit
      }
    }
  }
}