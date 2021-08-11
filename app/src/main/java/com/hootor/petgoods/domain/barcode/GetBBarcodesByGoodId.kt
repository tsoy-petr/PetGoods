package com.hootor.petgoods.domain.barcode

import com.hootor.petgoods.domain.base.Either
import com.hootor.petgoods.domain.base.Failure
import com.hootor.petgoods.domain.base.UseCase

class GetBBarcodesByGoodId(
    private val barcodeRepository: BarcodeRepository
) : UseCase<List<Barcode>, GetBBarcodesByGoodId.Params>() {

    override fun run(params: Params): Either<Failure, List<Barcode>> =
        barcodeRepository.getBarcodesByGoodId(params.goodId)

    class Params(val goodId: String)
}