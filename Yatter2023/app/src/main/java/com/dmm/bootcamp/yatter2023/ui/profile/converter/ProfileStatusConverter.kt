//package com.dmm.bootcamp.yatter2023.ui.profile.converter
//
//import com.dmm.bootcamp.yatter2023.domain.model.Status
//import com.dmm.bootcamp.yatter2023.ui.profile.bindingmodel.ProfileStatusBindingModel
//
//object ProfileStatusConverter {
//    fun convertToProfileBindingModel(statusList: List<Status>): List<ProfileStatusBindingModel> =
//        statusList.map { convertToProfileBindingModel(it) }
//
//    fun convertToProfileBindingModel(status: Status): ProfileStatusBindingModel =
//        ProfileStatusBindingModel(
//            id = status.id.value,
//            displayName = status.account.displayName ?: "",
//            username = status.account.username.value,
//            avatar = status.account.avatar.toString(),
//            content = status.content,
//            attachmentMediaList = ProfileMediaConverter.convertToProfileDomainModel(status.attachmentMediaList)
//        )
//}