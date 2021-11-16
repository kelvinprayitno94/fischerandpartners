package com.test.enigma.koin

import com.test.enigma.model.MovieCategoryResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("3/genre/movie/list")
    fun getMovieCategories(
        @Query("api_key") apiKey: String
    ): Single<MovieCategoryResponse>
}