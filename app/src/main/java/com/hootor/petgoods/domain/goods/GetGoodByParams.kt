package com.hootor.petgoods.domain.goods

import com.hootor.petgoods.domain.base.Either
import com.hootor.petgoods.domain.base.Failure
import com.hootor.petgoods.domain.base.UseCase

class GetGoodByParams(
    private val repository: GoodsRepository
) : UseCase<Good?, GetGoodByParams.Params>() {

    override fun run(params: Params): Either<Failure, Good?> = when (params) {
        is Params.ById -> {
            repository.getGoodById(params.id)
        }
        is Params.ByBarcode -> {
            repository.getGoodByBarcode(params.barcode)
        }
    }

    sealed class Params() {
        class ById(val id: String) : Params()
        class ByBarcode(val barcode: String) : Params()
    }
}