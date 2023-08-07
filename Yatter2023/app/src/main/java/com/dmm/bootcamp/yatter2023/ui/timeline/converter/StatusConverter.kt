package com.dmm.bootcamp.yatter2023.ui.timeline.converter

import com.dmm.bootcamp.yatter2023.domain.model.Status
import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.StatusBindingModel

object StatusConverter {
    fun convertToBindingModel(statusList: List<Status>): List<StatusBindingModel> =
        statusList.map { convertToBindingModel(it) }

    fun convertToBindingModel(status: Status): StatusBindingModel =
        //(status引数の名前: //Statusという形で受け取る //ステータスを受け取る): StatusBindingModel //これが帰り値 //=はreturnと一緒
        StatusBindingModel(
            id = status.id.value,
            displayName = status.account.displayName ?: "",
            username = status.account.username.value,
            avatar = status.account.avatar.toString(),
            content = status.content,
            attachmentMediaList = MediaConverter.convertToDomainModel(status.attachmentMediaList)
        )
}