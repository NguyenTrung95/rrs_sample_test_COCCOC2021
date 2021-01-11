package com.coccoc.rssreader.util

import android.content.Context
import android.widget.Toast
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
val HABR_DATE_FORMAT = SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH)
val URL_KEY = "URL_KEY"
fun parseHabrDate(date: String): Long {
    return try {
        HABR_DATE_FORMAT.parse(date)?.time ?: System.currentTimeMillis()
    } catch (e: Exception) {
        Timber.e(e)
        System.currentTimeMillis()
    }
}

fun getDateFormat(timestamp : Long) : String{
    val sdf = SimpleDateFormat("dd/MM/yy hh:mm a")
    val netDate = Date(timestamp)
    return sdf.format(netDate)

}

inline fun <reified T : Enum<T>> enumValueOf(name: String?, defaultValue: T): T {
    return try {
        enumValues<T>().first { it.name == name }
    } catch (e: NoSuchElementException) {
        defaultValue
    }
}

fun Context.showToast(resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resId, duration).show()
}
