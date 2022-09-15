package mobi.argun.newsapp_android.feature.data.remote.util

import mobi.argun.newsapp_android.core.util.DataResult
import mobi.argun.newsapp_android.core.util.*
import org.json.JSONObject
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class RemoteDataSource {

    open suspend fun <T> performApiCall(
        call: suspend () -> Response<T>
    ): DataResult<T> {
        return try {
            val response = call.invoke()

            if (response.isSuccessful) {
                Success(response.body())
            } else {
                throw HttpException(response)
            }
        } catch (exception: Exception) {
            handleError(exception)
        }
    }

    private fun handleError(exception: Exception): DataResult<Nothing> {
        return when(exception) {
            is HttpException -> {
                val result = when (exception.code()) {
                    //in 400..451 -> parseHttpError(exception)
                    in 500..599 -> Error(
                        HttpResult.SERVER_ERROR,
                        exception.code(),
                        "Server error"
                    )
                    else -> Error(
                        HttpResult.NOT_DEFINED,
                        exception.code(),
                        "Oops, something went wrong!"
                    )
                }
                result
            }
            is UnknownHostException -> Error(
                HttpResult.NO_CONNECTION,
                null,
                "No internet connection"
            )
            is SocketTimeoutException -> Error(HttpResult.TIMEOUT, null, "Slow connection")
            is IOException -> Error(HttpResult.BAD_RESPONSE, null, exception.message)
            else -> Error(HttpResult.NOT_DEFINED, null, exception.message)
        }
    }

    private fun parseHttpError(throwable: HttpException): DataResult<Nothing> {
        return try {
            val errorBody = throwable.response()?.errorBody()
            val jsonObject = errorBody?.let { JSONObject(it.string()) }
            val errorMessage = jsonObject!!.getString("Message")
            Error(HttpResult.CLIENT_ERROR, throwable.code(), errorMessage.toString())
        } catch (exception: Exception) {
            Error(HttpResult.CLIENT_ERROR, throwable.code(), exception.localizedMessage)
        }
    }
}