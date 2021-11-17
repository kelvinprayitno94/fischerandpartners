package com.test.enigma.koin

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

var prefModule = module {
    single(named("prefs")) {
        provideEncryptedPreferences(androidContext())
    }
    single<SharedPrefRepoContract> {
        SharedPrefRepository(sharedPref = get(named("prefs")))
    }
}

const val SECURE_PREFS_FILE_KEY = "com.test.fischerpartners.shared_preferences"

fun provideEncryptedPreferences(context: Context): SharedPreferences {

    return context.getSharedPreferences(SECURE_PREFS_FILE_KEY, Context.MODE_PRIVATE)

}
