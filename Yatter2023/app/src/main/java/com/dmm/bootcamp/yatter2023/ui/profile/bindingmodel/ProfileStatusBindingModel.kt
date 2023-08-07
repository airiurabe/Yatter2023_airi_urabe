package com.dmm.bootcamp.yatter2023.ui.profile.bindingmodel

import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.MediaBindingModel

data class ProfileStatusBindingModel(
    val id: String,
    val displayName: String,
    val username: String,
    val avatar: String?,
    val content: String,
    val attachmentMediaList: List<ProfileMediaBindingModel>
)