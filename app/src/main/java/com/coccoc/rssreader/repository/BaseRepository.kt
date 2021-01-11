package com.coccoc.rssreader.repository

import com.coccoc.rssreader.util.Result
import retrofit2.Response
import java.io.IOException

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
open class BaseRepository {

    protected suspend fun <S : Any, D : Any> safeApiCall(
            errorMessage: String = "",
            converter: (S) -> D,
            call: suspend () -> Response<S>
    ): Result<D> {
        try {
            val response = call.invoke()
            if (response.isSuccessful) {
                return Result.Success(converter.invoke(response.body()!!))
            }

            return Result.Fail(
                    errorMessage,
                    IOException("Error (code: ${response.code()}) occurred during safe Api call: ${response.errorBody()?.string()}")
            )
        } catch (e: IOException) {
            return Result.Fail(errorMessage, e)
        }
    }
}
