package com.kino.app.common.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {

    companion object {

        val DATE_FORMAT_1 : String = "LLL dd, yyyy"
        val DATE_FORMAT_2 : String = "dd LLL yyyy 'at' h:mm a"
        val DATE_FORMAT_3 : String = "yyyy"
        val DATE_FORMAT_4 : String = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        val DATE_FORMAT_5 : String = "h'h' mm'mins'"

        fun format(epoch: Long, format: String): String {
            val sdf = SimpleDateFormat(format)
            val netDate = Date(epoch * 1000)
            return sdf.format(netDate)
        }

        fun format(dateRaw: String, format: String): String {
            val date: Date = SimpleDateFormat(DATE_FORMAT_4).parse(dateRaw)
            return SimpleDateFormat(format).format(date)
        }
    }
}