package com.hootor.petgoods.domain.image

class Image(
    val id: String,
    val goodId: String,
    val name: String = "",
    val imgDigit: ByteArray? = null
)