package com.dmm.bootcamp.yatter2023.infra.domain.repository

import com.dmm.bootcamp.yatter2023.domain.model.Account
import com.dmm.bootcamp.yatter2023.domain.model.Me
import com.dmm.bootcamp.yatter2023.domain.model.Password
import com.dmm.bootcamp.yatter2023.domain.model.Username
import com.dmm.bootcamp.yatter2023.domain.repository.AccountRepository
import com.dmm.bootcamp.yatter2023.infra.api.YatterApi
import com.dmm.bootcamp.yatter2023.infra.api.json.CreateAccountJson
import com.dmm.bootcamp.yatter2023.infra.domain.converter.AccountConverter
import com.dmm.bootcamp.yatter2023.infra.domain.converter.MeConverter
import com.dmm.bootcamp.yatter2023.infra.pref.MePreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class AccountRepositoryImpl(
  private val yatterApi: YatterApi,
  private val mePreferences: MePreferences, //自分の一部の情報はローカル（スマホの中）に保存されている
) : AccountRepository {

  override suspend fun create(
    username: Username,
    password: Password
  ): Me = withContext(Dispatchers.IO) {
    val accountJson = yatterApi.createNewAccount(
      CreateAccountJson(
        username = username.value,
        password = password.value
      )
    )

    MeConverter.convertToMe(AccountConverter.convertToDomainModel(accountJson))
  }

  override suspend fun findMe(): Me? = withContext(Dispatchers.IO) { //別スレッドでMe情報を取得
    //スレッド=処理の1単位、Androidではメインスレッドは1つだけ
    //withContext...通信処理は他のスレッドでやることを指定
    //通信している間に他の処理ができる ex)ロード中のアニメーションを表示
    val username = mePreferences.getUsername() ?: return@withContext null
    if (username.isEmpty()) return@withContext null //return@withContext Me情報の取得終了
    val account = findByUsername(username = Username(username))
    MeConverter.convertToMe(account)
  }

  override suspend fun findByUsername(username: Username): Account = withContext(Dispatchers.IO) {
    //usernameを指定するとAccount情報を返す
    val accountJson = yatterApi.getAccountByUsername(username = username.value)
    AccountConverter.convertToDomainModel(accountJson)
  } //サーバーからユーザーの情報（Json）を取ってきているところ

  override suspend fun update(
    me: Me,
    newDisplayName: String?,
    newNote: String?,
    newAvatar: URL?,
    newHeader: URL?
  ): Me {
    TODO("Not yet implemented")
  }
}
