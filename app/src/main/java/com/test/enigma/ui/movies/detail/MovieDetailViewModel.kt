package com.test.enigma.ui.movies.detail

import androidx.lifecycle.MutableLiveData
import com.test.enigma.base.BaseViewModel
import com.test.enigma.koin.ApiRepoContract
import com.test.enigma.model.MovieDetailResponse
import com.test.enigma.model.MovieReviewResponse
import com.test.enigma.model.MovieVideoResponse
import com.test.enigma.util.ViewStateModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailViewModel(
    private val apiRepoContract: ApiRepoContract
) : BaseViewModel() {
    val movieDetailLiveData: MutableLiveData<MovieDetailResponse> = MutableLiveData()
    val movieVideoLiveData: MutableLiveData<MovieVideoResponse> = MutableLiveData()
    val movieReviewLiveData: MutableLiveData<MovieReviewResponse> = MutableLiveData()

    private var isLoadReview = false
    private var totalPages = 1

    fun getMovieDetail(id: Int) {
        viewStateLiveData.value = ViewStateModel.SUCCESS

        apiRepoContract.getMovieDetail(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    movieDetailLiveData.value = it

                    viewStateLiveData.value = ViewStateModel.SUCCESS
                },
                {
                    viewStateLiveData.value = ViewStateModel.FAILED
                }
            ).addToDisposable()
    }

    fun getMovieVideo(id: Int) {

        apiRepoContract.getMovieVideo(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    movieVideoLiveData.value = it
                },
                {
                }
            ).addToDisposable()
    }

    fun getMovieReview(page: Int, id: Int) {

        if (!isLoadReview && page <= totalPages) {
            isLoadReview = true

            apiRepoContract.getMovieReview(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        movieReviewLiveData.value = it
                        totalPages = it.totalPages
                        isLoadReview = false
                    },
                    {
                        isLoadReview = false
                    }
                ).addToDisposable()
        }
    }
}