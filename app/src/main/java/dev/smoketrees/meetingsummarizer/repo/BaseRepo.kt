package dev.smoketrees.meetingsummarizer.repo


import androidx.lifecycle.liveData
import dev.smoketrees.meetingsummarizer.models.ApiResult

open class BaseRepo {
    protected fun <T> makeRequest(request: suspend () -> ApiResult<T>) = liveData {
        emit(ApiResult.Loading<T>())

        when (val response = request.invoke()) {
            is ApiResult.Success -> {
                emit(response)
            }
            is ApiResult.Error -> {
                emit(response)
            }
            else -> {
            }
        }
    }
}