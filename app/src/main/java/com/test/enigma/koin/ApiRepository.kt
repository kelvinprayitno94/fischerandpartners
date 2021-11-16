package com.test.enigma.koin

import com.test.enigma.model.MovieCategoryResponse
import com.test.enigma.util.API_KEY
import io.reactivex.Single

class ApiRepository(
    private val apiServices: ApiService
) : ApiRepoContract {
    override fun getMovieCategories(): Single<MovieCategoryResponse> =
        apiServices.getMovieCategories(API_KEY)

}
