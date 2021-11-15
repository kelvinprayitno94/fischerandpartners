package com.test.enigma.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

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
