package com.test.enigma.ui.movies.list

import android.view.LayoutInflater
import com.test.enigma.base.BaseKoinActivityBinding
import com.test.enigma.databinding.ActivityMovieListBinding

class MovieListActivity: BaseKoinActivityBinding<ActivityMovieListBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMovieListBinding
        get() = ActivityMovieListBinding::inflate

    override fun setupView(binding: ActivityMovieListBinding) {
        initEvent(binding)
        initObserver()
    }

    private fun initObserver() {

    }

    private fun initEvent(binding: ActivityMovieListBinding) {

    }
}