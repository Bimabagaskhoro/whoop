package com.whoop.app.core.base.utils

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

sealed class UiState<out T> {
    data object Default : UiState<Nothing>()
    data object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Failure(val throwable: Throwable) : UiState<Nothing>()
    data class FailureNetwork(val ioExc: IOException) : UiState<Nothing>()
    data object Empty : UiState<Nothing>()
}

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Failure(val exception: Throwable) : NetworkResult<Nothing>()
    data class FailureResult<T>(val dataThrow: T) : NetworkResult<T>()
    companion object {
        fun <T> success(data: T): NetworkResult<T> = Success(data)
        fun failure(exception: Throwable): NetworkResult<Nothing> = Failure(exception)
        fun <T> failureResult(dataThrowable: T): NetworkResult<T> = FailureResult(dataThrowable)
    }
}

suspend inline fun <reified T> makeRequestNetworkResult(crossinline request: suspend () -> HttpResponse): NetworkResult<T> {
    return try {
        val response: HttpResponse = request()
        if (response.status == HttpStatusCode.OK) {
            NetworkResult.success(response.body())
        } else {
            NetworkResult.failureResult(response.body())
        }
    } catch (e: Throwable) {
        NetworkResult.failure(e)
    }
}

suspend inline fun <reified T> makeRequest(crossinline request: suspend () -> HttpResponse): T {
    return try {
        val response: HttpResponse = request()
        if (response.status == HttpStatusCode.OK) {
            request().body()
        } else {
            throw Exception("${response.status.value}")
        }
    } catch (e: Throwable) {
        throw e
    }
}

suspend fun <T> MutableStateFlow<UiState<T>>.asUiState(
    action: suspend () -> T
) {
    this.update { UiState.Loading }
    try {
        val data = action()
        if (data != null) {
            this.update { UiState.Success(data) }
        } else {
            this.update { UiState.Empty }
        }

    } catch (error: Throwable) {
        when (error) {
            is IOException -> {
                this.update { UiState.FailureNetwork(error) }
            }

            else -> {
                this.update { UiState.Failure(error) }
            }
        }
    }
}

suspend fun <T> Channel<UiState<T>>.asUiStateChannel(
    action: suspend () -> T
) {
    this.send(UiState.Loading)
    try {
        val data = action()
        if (data != null) {
            this.send(UiState.Success(data))
        } else {
            this.send(UiState.Empty)
        }

    } catch (error: Throwable) {
        when (error) {
            is IOException -> {
                this.send(UiState.FailureNetwork(error))
            }

            else -> {
                this.send(UiState.Failure(error))
            }
        }
    }
}

inline fun <T> UiState<T>.onDefault(action: () -> Unit): UiState<T> = apply {
    if (this is UiState.Empty) {
        action()
    }
}

inline fun <T> UiState<T>.onLoading(action: () -> Unit): UiState<T> = apply {
    if (this is UiState.Loading) {
        action()
    }
}

inline fun <T> UiState<T>.onSuccess(action: (data: T) -> Unit): UiState<T> = apply {
    if (this is UiState.Success) {
        action(data)
    }
}

inline fun <T> UiState<T>.onError(action: (throwable: Throwable) -> Unit): UiState<T> = apply {
    if (this is UiState.Failure) {
        action(throwable)
    }
}

inline fun <T> UiState<T>.onEConnection(action: (ioExc: IOException) -> Unit): UiState<T> = apply {
    if (this is UiState.FailureNetwork) {
        action(ioExc)
    }
}
