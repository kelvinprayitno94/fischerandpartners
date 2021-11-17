package com.test.enigma.ui.movies.detail

import androidx.lifecycle.MutableLiveData
import com.test.enigma.base.BaseViewModel
import com.test.enigma.koin.ApiRepoContract
import com.test.enigma.model.MovieDetailResponse
import com.test.enigma.model.MovieVideoResponse
import com.test.enigma.util.ViewStateModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailViewModel(
    private val apiRepoContract: ApiRepoContract
) : BaseViewModel() {
    val movieDetailLiveData: MutableLiveData<MovieDetailResponse> = MutableLiveData()
    val movieVideoLiveData: MutableLiveData<MovieVideoResponse> = MutableLiveData()

    fun getMovieDetail(id: Int) {
        viewStateLiveData.value = ViewStateModel.SUCCESS

        apiRepoContract.getMovieDetail(490132)
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

        apiRepoContract.getMovieVideo(490132)
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
}