package com.hootor.petgoods.domain.goods

import com.hootor.petgoods.domain.base.Either
import com.hootor.petgoods.domain.base.Failure
import com.hootor.petgoods.domain.base.None

interface GoodsRepository {
    fun getGoodsByParent(parent: String): Either<Failure, List<Good>>
    fun getGoodById(id: String): Either<Failure, Good?>
    fun getGoodByBarcode(id: String): Either<Failure, Good?>
    fun findAllParent(id: String): Either<Failure, List<Good>>
    fun saveGoods(goods: List<Good>) : Either<Failure, None>
}