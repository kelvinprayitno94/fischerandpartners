package com.test.enigma.koin

import com.test.enigma.model.MovieCategoryResponse
import io.reactivex.Single

interface ApiRepoContract {
    fun getMovieCategories(): Single<MovieCategoryResponse>
}
