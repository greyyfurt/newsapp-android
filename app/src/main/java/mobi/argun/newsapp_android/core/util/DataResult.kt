package mobi.argun.newsapp_android.core.util

import mobi.argun.newsapp_android.feature.data.remote.util.HttpResult

sealed class DataResult<out T>

object Empty : DataResult<Nothing>()
object Loading : DataResult<Nothing>()
data class Success<out T : Any>(val data: T?) : DataResult<T>()
data class Error(val cause: HttpResult, val code: Int?, val errorMessage: String?) :
    DataResult<Nothing>()