package com.yehorlevchenko.domain.utils

sealed class Result<out T> {

    data object Loading : Result<Nothing>()

    data object Empty : Result<Nothing>()

    data class Success<out T>(val data: T) : Result<T>()

    data class Failure(val throwable: Throwable) : Result<Nothing>()
}