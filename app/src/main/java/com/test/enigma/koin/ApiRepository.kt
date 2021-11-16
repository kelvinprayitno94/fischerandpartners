package com.test.enigma.koin

import com.test.enigma.model.MovieCategoryResponse
import com.test.enigma.model.MovieListResponse
import com.test.enigma.util.API_KEY
import com.test.enigma.util.LANG
import io.reactivex.Single

class ApiRepository(
    private val apiServices: ApiService
) : ApiRepoContract {
    override fun getMovieCategories(): Single<MovieCategoryResponse> =
        apiServices.getMovieCategories(API_KEY)

    override fun getMovieList(id: Int): Single<MovieListResponse> =
        apiServices.getMovieList(API_KEY, LANG, id)

}
