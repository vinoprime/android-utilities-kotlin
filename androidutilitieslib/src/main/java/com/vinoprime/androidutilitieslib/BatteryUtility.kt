package com.vinoprime.androidutilitieslib

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager

class BatteryUtility {

    private val TAG = "BatteryUtility"

    fun batteryLevel(context: Context): Int {
        val ifilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus = context.registerReceiver(null, ifilter)
        return batteryStatus!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)

    }

    fun batteryScale(context: Context): Int {
        val ifilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus = context.registerReceiver(null, ifilter)
        return batteryStatus!!.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
    }

    fun batteryPercentage(context: Context): Float {
        return batteryLevel(context) / batteryScale(context).toFloat()
    }
}