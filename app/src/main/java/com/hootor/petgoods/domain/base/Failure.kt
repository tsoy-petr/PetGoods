package com.hootor.petgoods.domain.base

sealed class Failure {
    object NetworkConnectionError : Failure()
    object ServerError : Failure()
}