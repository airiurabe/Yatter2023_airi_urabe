//package com.dmm.bootcamp.yatter2023.ui.profile.converter
//
//import com.dmm.bootcamp.yatter2023.domain.model.Status
//import com.dmm.bootcamp.yatter2023.ui.profile.bindingmodel.ProfileStatusBindingModel
//import com.dmm.bootcamp.yatter2023.ui.timeline.converter.MediaConverter
//
//object ProfileMediaConverter {
//    fun convertToProfileBindingModel(statusList: List<Status>): List<ProfileStatusBindingModel> =
//        statusList.map { convertToProfileBindingModel(it) }
//
//    fun convertToProfileBindingModel(status: Status): ProfileStatusBindingModel =
//        //(status引数の名前: //Statusという形で受け取る //ステータスを受け取る): StatusBindingModel //これが帰り値 //=はreturnと一緒
//        ProfileStatusBindingModel(
//            id = status.id.value,
//            displayName = status.account.displayName ?: "",
//            username = status.account.username.value,
//            avatar = status.account.avatar.toString(),
//            content = status.content,
//            attachmentMediaList = MediaConverter.convertToProfileDomainModel(status.attachmentMediaList)
//        )
//}