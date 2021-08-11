package com.hootor.petgoods.domain.goods

class Good(
    val id: String,
    val parent: String = "",
    val imageId: String = "",
    val isGroup: Boolean = false,
    val name: String,
    val vendorCode: String,
    val deletionMark: Boolean,
)