package com.test.enigma.koin

import com.test.enigma.model.MovieCategoryResponse
import com.test.enigma.model.MovieDetailResponse
import com.test.enigma.model.MovieListResponse
import com.test.enigma.model.MovieVideoResponse
import io.reactivex.Single

interface ApiRepoContract {
    fun getMovieCategories(): Single<MovieCategoryResponse>
    fun getMovieList(id: Int): Single<MovieListResponse>
    fun getMovieDetail(id: Int): Single<MovieDetailResponse>
    fun getMovieVideo(id: Int): Single<MovieVideoResponse>
}
