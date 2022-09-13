@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package mobi.argun.newsapp_android.core.util.converter

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author greyyfurt
 * Created on 12.09.2022
 */
object DateFormatting {

    @SuppressLint("SimpleDateFormat")
    fun convertDateFormat(date: String?): String {
        date?.let {
            if (date.isEmpty())
                return ""
            var sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val newDate: Date = sdf.parse(it)
            sdf = SimpleDateFormat("dd.MM.yyyy")
            return sdf.format(newDate).orEmpty()
        } ?: return ""
    }
}