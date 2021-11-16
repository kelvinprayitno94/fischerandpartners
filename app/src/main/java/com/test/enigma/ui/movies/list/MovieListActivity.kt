package com.test.enigma.ui.movies.list

import android.view.LayoutInflater
import com.test.enigma.base.BaseKoinActivityBinding
import com.test.enigma.base.setGone
import com.test.enigma.base.setVisible
import com.test.enigma.databinding.ActivityMovieListBinding
import com.test.enigma.model.MovieItems
import com.test.enigma.util.ID_ARGS
import com.test.enigma.util.ViewStateModel
import kotlinx.android.synthetic.main.activity_movie_list.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MovieListActivity : BaseKoinActivityBinding<ActivityMovieListBinding>(), MovieListListener {
    private val movieListViewModel: MovieListViewModel by inject {
        parametersOf(this)
    }

    val movieListAdapter: MovieListAdapter by inject {
        parametersOf(this)
    }

    override val bindingInflater: (LayoutInflater) -> ActivityMovieListBinding
        get() = ActivityMovieListBinding::inflate

    override fun setupView(binding: ActivityMovieListBinding) {
        setupRecyclerView()

        initEvent(binding)
        initObserver()

        movieListViewModel.getMovieList(intent.getIntExtra(ID_ARGS, 0))
    }

    private fun initObserver() {
        movieListViewModel.movieListLiveData.observe(this@MovieListActivity)
        {
            movieListAdapter.updateList(it.items)
        }

        movieListViewModel.viewStateLiveData.observe(this@MovieListActivity)
        {
            when (it) {
                ViewStateModel.LOADING -> {
                    progressBarMovieList.setVisible()
                }
                ViewStateModel.FAILED -> {
                    progressBarMovieList.setGone()
                }
                ViewStateModel.SUCCESS -> {
                    progressBarMovieList.setGone()
                }
            }
        }
    }

    private fun initEvent(binding: ActivityMovieListBinding) {

    }

    override fun onMovieListClick(item: MovieItems) {

    }
}