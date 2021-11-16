package com.test.enigma.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.enigma.util.ViewStateModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    val viewStateLiveData: MutableLiveData<ViewStateModel> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    protected fun Disposable.addToDisposable() = compositeDisposable.add(this)

    fun addToDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}
