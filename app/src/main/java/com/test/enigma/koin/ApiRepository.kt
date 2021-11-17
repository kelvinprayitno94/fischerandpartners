package com.test.enigma.koin

import com.test.enigma.model.MovieCategoryResponse
import com.test.enigma.model.MovieDetailResponse
import com.test.enigma.model.MovieListResponse
import com.test.enigma.model.MovieVideoResponse
import com.test.enigma.util.API_KEY
import com.test.enigma.util.LANG
import io.reactivex.Single

class ApiRepository(
    private val apiServices: ApiService
) : ApiRepoContract {
    override fun getMovieCategories(): Single<MovieCategoryResponse> =
        apiServices.getMovieCategories(API_KEY)

    override fun getMovieList(id: Int): Single<MovieListResponse> =
        apiServices.getMovieList(id, API_KEY, LANG)

    override fun getMovieDetail(id: Int): Single<MovieDetailResponse> =
        apiServices.getMovieDetail(id, API_KEY, LANG)

    override fun getMovieVideo(id: Int): Single<MovieVideoResponse> =
        apiServices.getMovieVideo(id, API_KEY, LANG)

}
