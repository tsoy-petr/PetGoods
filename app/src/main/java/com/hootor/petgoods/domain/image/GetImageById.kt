package com.hootor.petgoods.domain.image

import com.hootor.petgoods.domain.base.Either
import com.hootor.petgoods.domain.base.Failure
import com.hootor.petgoods.domain.base.UseCase

class GetImageById(
    private val imageRepository: ImageRepository
) : UseCase<Image?, GetImageById.Params>() {

    override fun run(params: Params): Either<Failure, Image?> =
        imageRepository.getImageById(params.imageId)

    class Params(val imageId: String)
}