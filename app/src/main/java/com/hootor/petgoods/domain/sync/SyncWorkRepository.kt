package com.hootor.petgoods.domain.sync

import com.hootor.petgoods.domain.base.Either
import com.hootor.petgoods.domain.base.Failure
import com.hootor.petgoods.domain.base.None

interface SyncRepository {
    fun sync(eventMessage: (String) -> Unit) : Either<Failure, None>
}