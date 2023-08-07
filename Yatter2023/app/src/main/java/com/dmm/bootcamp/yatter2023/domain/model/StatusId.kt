package com.dmm.bootcamp.yatter2023.domain.model

import com.dmm.bootcamp.yatter2023.common.ddd.Identifier

class StatusId(value: String) : Identifier<String>(value)

class UserStatusId(value: String) : Identifier<String>(value) {}
    //UserStatusのIDを表す識別子

data class UserStatus(
    val id: UserStatusId,
    val accountName: String,
    val userProfileImage: Media,
) //UserStatusIdを含む他のプロパティを持つデータクラス