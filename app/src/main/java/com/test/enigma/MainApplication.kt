package com.test.enigma

import android.app.Application
import com.test.enigma.koin.networkModule
import com.test.enigma.koin.apiRepoContractModule
import com.test.enigma.koin.viewControllerModule
import timber.log.Timber

class MainApplication: Application() {
    companion object {
        private val modules = listOf(
            viewControllerModule,
            apiRepoContractModule,
            networkModule,
//            roomModule,
//            roomRepositoryModule,
            prefModule
        )
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        initKoin()
    }

    private fun initKoin() = startKoin {
        androidContext(this@MainApplication)

        val moduleList = arrayListOf<Module>().apply {
            addAll(modules)
        }

        modules(moduleList)
    }
}