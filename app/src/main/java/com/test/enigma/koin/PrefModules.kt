package com.test.enigma.koin

import android.content.Context
import android.content.SharedPreferences

var prefModule = module {
    single(named("prefs")) {
        provideEncryptedPreferences(androidContext())
    }
    single<SharedPreferencesRepoContract> {
        SharedPreferences(pref = get(named("prefs")))
    }
}

const val SECURE_PREFS_FILE_KEY = "com.test.enigma.secure_preferences"

fun provideEncryptedPreferences(context: Context): SharedPreferences {

    return context.getSharedPreferences(SECURE_PREFS_FILE_KEY, Context.MODE_PRIVATE)

}
