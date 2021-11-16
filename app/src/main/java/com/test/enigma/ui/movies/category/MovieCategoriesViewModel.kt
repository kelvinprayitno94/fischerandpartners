package com.test.enigma.ui.movies.category

import androidx.lifecycle.MutableLiveData
import com.test.enigma.base.BaseViewModel
import com.test.enigma.koin.ApiRepoContract
import com.test.enigma.model.MovieCategoryResponse
import com.test.enigma.util.ViewStateModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieCategoriesViewModel(
    private val apiRepoContract: ApiRepoContract
): BaseViewModel() {
    val eventDetailLiveData: MutableLiveData<MovieCategoryResponse> = MutableLiveData()

    fun getMovieCategory() {
        viewStateLiveData.value = ViewStateModel.SUCCESS

        apiRepoContract.getMovieCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    eventDetailLiveData.postValue(it)

                    viewStateLiveData.value = ViewStateModel.SUCCESS
                },
                {
                    viewStateLiveData.value = ViewStateModel.FAILED
                }
            ).addToDisposable()
    }
}