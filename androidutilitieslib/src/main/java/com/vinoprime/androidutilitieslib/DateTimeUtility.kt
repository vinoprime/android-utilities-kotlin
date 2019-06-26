package com.vinoprime.androidutilitieslib

import java.text.SimpleDateFormat
import java.util.*

class DateTimeUtility {

    private val TAG = "DateTimeUtility"

    fun getCurrentTimeStamp(): String? {
        try {
            //            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy"); //MUST USE LOWERCASE 'y'. API 23- can't use uppercase
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return dateFormat.format(Date()) // Find todays date

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }

    fun getMonthFromNumber(monthNumber: String): String {
        when (monthNumber) {
            "01" -> {
                return "Jan"
            }
            "02" -> {
                return "Feb"
            }
            "03" -> {
                return "Mar"
            }
            "04" -> {
                return "Apr"
            }
            "05" -> {
                return "May"
            }
            "06" -> {
                return "Jun"
            }
            "07" -> {
                return "Jul"
            }
            "08" -> {
                return "Aug"
            }
            "09" -> {
                return "Sep"
            }
            "10" -> {
                return "Oct"
            }
            "11" -> {
                return "Nov"
            }
            "12" -> {
                return "Dec"
            }

            else -> {
                return "Error"
            }
        }
    }

}