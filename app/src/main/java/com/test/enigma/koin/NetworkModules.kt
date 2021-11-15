package com.bnc.fetest.koinDI

import com.google.gson.GsonBuilder
import com.bnc.fetest.dagger.module.HEAD_URL
import com.bnc.fetest.retrofit.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS

val networkModule = module {
    single {
        initRetrofit()
    }
}

fun initRetrofit(
): ApiService {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY

    val _client =
        OkHttpClient.Builder()
            .callTimeout(60, SECONDS)
            .connectTimeout(60, SECONDS)
            .addInterceptor(logging)

    val gson = GsonBuilder()
        .create()

    val retrofit = Retrofit.Builder()
        .baseUrl(HEAD_URL)
        .client(_client.build())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)
}
