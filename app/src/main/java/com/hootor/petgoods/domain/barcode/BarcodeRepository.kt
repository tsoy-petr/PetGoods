package com.hootor.petgoods.domain.barcode

import com.hootor.petgoods.domain.base.Either
import com.hootor.petgoods.domain.base.Failure
import com.hootor.petgoods.domain.base.None

interface BarcodeRepository {
    fun getBarcodesByGoodId(goodId: String): Either<Failure, List<Barcode>>
    fun saveBarcodes(barcodes: List<Barcode>): Either<Failure, None>
}