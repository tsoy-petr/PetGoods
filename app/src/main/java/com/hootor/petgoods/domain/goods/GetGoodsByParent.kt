package com.hootor.petgoods.domain.goods

import com.hootor.petgoods.domain.base.Either
import com.hootor.petgoods.domain.base.Failure
import com.hootor.petgoods.domain.base.UseCase

class GetGoodsByParent(
    private val goodsRepository: GoodsRepository
) : UseCase<List<Good>, GetGoodsByParent.Params>() {

    override fun run(params: Params): Either<Failure, List<Good>> = goodsRepository.getGoodsByParent(params.parent)

    class Params(val parent: String)
}