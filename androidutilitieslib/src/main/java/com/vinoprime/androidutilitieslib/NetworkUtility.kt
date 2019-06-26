package com.vinoprime.androidutilitieslib

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class NetworkUtility {


    private val TAG = "NetworkUtility"

    val WIFI_DATA = "wifi"
    val MOBILE_DATA = "mobile"
    val NONE = "none"

    //    @IntRange(from = 0, to = 2)
    fun getConnectionType(context: Context): String {
        var result = NONE // Returns connection type. 0: none; 1: mobile data; 2: wifi
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (cm != null) {
                val capabilities = cm.getNetworkCapabilities(cm.activeNetwork)
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        result = WIFI_DATA
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        result = MOBILE_DATA
                    }
                }
            }
        } else {
            if (cm != null) {
                val activeNetwork = cm.activeNetworkInfo
                if (activeNetwork != null) {
                    // connected to the internet
                    if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
                        result = WIFI_DATA
                    } else if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                        result = MOBILE_DATA
                    }
                }
            }
        }
        return result
    }
}