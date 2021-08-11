package com.hootor.petgoods.domain.image

import com.hootor.petgoods.domain.base.Either
import com.hootor.petgoods.domain.base.Failure
import com.hootor.petgoods.domain.base.None

interface ImageRepository {
    fun getImageById(imageId: String) : Either<Failure, Image?>
    fun saveImage(image: Image) : Either<Failure, None>
}