package com.fakhrulasa.samsungalbum.core.base

abstract class BaseUseCase<in Params, out T> {

    // This is the abstract function to be overridden in each specific use case
    abstract suspend fun execute(): Resource<T>
}