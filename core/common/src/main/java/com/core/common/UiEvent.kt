package com.core.common

sealed class UiEvent<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(): UiEvent<T>()

    class Success<T>(data: T?): UiEvent<T>()

    class Error<T>(message: String?): UiEvent<T>()
}