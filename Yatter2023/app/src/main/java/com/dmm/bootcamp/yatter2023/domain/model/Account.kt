package com.dmm.bootcamp.yatter2023.domain.model

import com.dmm.bootcamp.yatter2023.common.ddd.Entity
import java.net.URL

abstract class Account( //インスタンス化するときに外から与える情報
  id: AccountId,
  val username: Username, //valは受け取ったものをこのclassの情報にできる
  val displayName: String?,
  val note: String?,
  val avatar: URL?,
  val header: URL?,
  val followingCount: Int,
  val followerCount: Int,
) : Entity<AccountId>(id) { //AccountIdから情報を取得している

  abstract suspend fun followings(): List<Account> //List＝アカウント情報を取ってくる

  abstract suspend fun followers(): List<Account>
}