package com.coccoc.rssreader.util

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
sealed class Result<out T: Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Fail(val message: String, val exception: Exception) : Result<Nothing>()
}
