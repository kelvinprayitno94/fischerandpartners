package com.test.enigma.ui.movies.list

import androidx.lifecycle.MutableLiveData
import com.test.enigma.base.BaseViewModel
import com.test.enigma.koin.ApiRepoContract
import com.test.enigma.model.MovieCategoryResponse
import com.test.enigma.model.MovieListResponse
import com.test.enigma.util.ViewStateModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieListViewModel(
    private val apiRepoContract: ApiRepoContract
): BaseViewModel() {
    val movieListLiveData: MutableLiveData<MovieListResponse> = MutableLiveData()

    fun getMovieList(id: Int, page: Int) {

        if (viewStateLiveData.value != ViewStateModel.LOADING) {

            viewStateLiveData.value = ViewStateModel.LOADING

            apiRepoContract.getMovieList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        movieListLiveData.postValue(it)

                        viewStateLiveData.value = ViewStateModel.SUCCESS
                    },
                    {
                        viewStateLiveData.value = ViewStateModel.FAILED
                    }
                ).addToDisposable()
        }
    }
}