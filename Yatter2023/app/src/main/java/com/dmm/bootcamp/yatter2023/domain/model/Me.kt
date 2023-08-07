package com.dmm.bootcamp.yatter2023.domain.model

import java.net.URL

//自分自身の情報
abstract class Me( //AccountにMeの情報を渡す必要がある
  id: AccountId,
  username: Username,
  displayName: String?,
  note: String?,
  avatar: URL?,
  header: URL?,
  followingCount: Int,
  followerCount: Int,
) : Account( //「:」でAccountを継承しているという意味
  id,
  username,
  displayName,
  note,
  avatar,
  header,
  followingCount,
  followerCount,
) {

  abstract suspend fun follow(username: Username) //フォローする（アクション）

  abstract suspend fun unfollow(username: Username) //フォロー解除する（アクション）
}