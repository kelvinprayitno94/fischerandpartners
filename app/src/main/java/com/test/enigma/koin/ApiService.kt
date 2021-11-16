package com.test.enigma.koin

import com.test.enigma.model.MovieCategoryResponse
import com.test.enigma.model.MovieListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("3/genre/movie/list")
    fun getMovieCategories(
        @Query("api_key") apiKey: String
    ): Single<MovieCategoryResponse>

    @GET("3/list/{id}")
    fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Path("id")id: Int
    ): Single<MovieListResponse>
}