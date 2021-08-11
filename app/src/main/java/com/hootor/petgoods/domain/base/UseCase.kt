package com.hootor.petgoods.domain.base

abstract class UseCase<out Type, in Params> {

    abstract fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        onResult(run(params))
    }
}
