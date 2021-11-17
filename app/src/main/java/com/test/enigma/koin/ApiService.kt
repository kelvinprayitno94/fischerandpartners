package com.test.enigma.koin

import com.test.enigma.model.MovieCategoryResponse
import com.test.enigma.model.MovieDetailResponse
import com.test.enigma.model.MovieListResponse
import com.test.enigma.model.MovieVideoResponse
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
        @Path("id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Single<MovieListResponse>

    @GET("3/movie/{id}")
    fun getMovieDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Single<MovieDetailResponse>

    @GET("3/movie/{id}/videos")
    fun getMovieVideo(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Single<MovieVideoResponse>
}