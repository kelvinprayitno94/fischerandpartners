package com.test.enigma.koin

import org.koin.dsl.module

val apiRepoContractModule = module {
    single<ApiRepoContract> {
        ApiRepository(
            apiServices = get()
        )
    }
}
