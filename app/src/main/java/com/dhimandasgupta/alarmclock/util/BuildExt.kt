package com.dhimandasgupta.alarmclock.util

import android.os.Build

fun isTiramisuPlus(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
}