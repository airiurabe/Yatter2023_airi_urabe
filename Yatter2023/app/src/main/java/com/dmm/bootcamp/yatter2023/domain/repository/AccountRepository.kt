package com.dmm.bootcamp.yatter2023.domain.repository

import com.dmm.bootcamp.yatter2023.domain.model.Account
import com.dmm.bootcamp.yatter2023.domain.model.Me
import com.dmm.bootcamp.yatter2023.domain.model.Password
import com.dmm.bootcamp.yatter2023.domain.model.Username
import java.net.URL

interface AccountRepository {
  suspend fun findMe(): Me?
  //?がつくと、返り値がなかった時にnullを返す

  suspend fun findByUsername(username: Username): Account?
  //viewModelで呼べばいい

  suspend fun create(
    username: Username,
    password: Password
  ): Me

  suspend fun update(
    me: Me,
    newDisplayName: String?,
    newNote: String?,
    newAvatar: URL?,
    newHeader: URL?
  ): Me
}
