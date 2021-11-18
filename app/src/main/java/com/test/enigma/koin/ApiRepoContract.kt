package com.test.enigma.koin

import com.test.enigma.model.*
import io.reactivex.Single

interface ApiRepoContract {
    fun getMovieCategories(): Single<MovieCategoryResponse>
    fun getMovieList(id: Int, page: Int): Single<MovieListResponse>
    fun getMovieDetail(id: Int): Single<MovieDetailResponse>
    fun getMovieVideo(id: Int): Single<MovieVideoResponse>
    fun getMovieReview(id: Int, page: Int): Single<MovieReviewResponse>
}
