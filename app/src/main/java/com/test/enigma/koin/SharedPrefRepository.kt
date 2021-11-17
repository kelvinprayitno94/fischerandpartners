package com.test.enigma.koin

import android.content.SharedPreferences

class SharedPrefRepository(private val sharedPref: SharedPreferences) : SharedPrefRepoContract {

    override fun clearSharedPref() {
        sharedPref.edit().clear().apply()
    }

    companion object {
        const val KEY_IS_LOGIN = "is_login"
        const val KEY_IS_INTRO = "is_intro"
        const val FAV_PREF = "fav_pref"
        const val PIN = "pin_value"
    }
}
