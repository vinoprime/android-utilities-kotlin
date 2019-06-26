package com.vinoprime.androidutilitieslib

import android.content.Context
import android.location.LocationManager
import com.vinoprime.errorloggerlib.ErrorLogger

class LocationUtility {

    private val TAG = "LocationUtility"

    val HARDWARE_ENABLED_GPS = 0
    val NETWORK_ENABLED_GPS = 1

    fun isCanAccesLocation(context: Context): BooleanArray {

        val lm = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var gps_enabled = false
        var network_enabled = false

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
        } catch (e: Exception) {
            ErrorLogger.displayOnLogcat(TAG, e)
        }

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        } catch (e: Exception) {
            ErrorLogger.displayOnLogcat(TAG, e)
        }

        //        if (gps_enabled || network_enabled) return true;
        val status = BooleanArray(2)
        status[HARDWARE_ENABLED_GPS] = gps_enabled
        status[NETWORK_ENABLED_GPS] = network_enabled

        return status
    }
}