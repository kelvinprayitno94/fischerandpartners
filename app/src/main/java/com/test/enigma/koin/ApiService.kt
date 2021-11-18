package com.test.enigma.koin

import com.test.enigma.model.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("3/genre/movie/list")
    fun getMovieCategories(
        @Query("api_key") apiKey: String
    ): Single<MovieCategoryResponse>

    @GET("3/movie/{id}/lists")
    fun getMovieList(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
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

    @GET("3/movie/{id}/reviews")
    fun getMovieReview(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Single<MovieReviewResponse>
}