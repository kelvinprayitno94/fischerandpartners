package com.test.enigma.koin

import com.test.enigma.model.MovieCategoryResponse
import com.test.enigma.model.MovieListResponse
import io.reactivex.Single

interface ApiRepoContract {
    fun getMovieCategories(): Single<MovieCategoryResponse>
    fun getMovieList(id: Int): Single<MovieListResponse>
}
