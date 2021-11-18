package com.test.enigma.ui.movies.list

import android.content.Intent
import android.view.LayoutInflater
import com.test.enigma.base.BaseKoinActivityBinding
import com.test.enigma.base.setGone
import com.test.enigma.base.setVisible
import com.test.enigma.databinding.ActivityMovieListBinding
import com.test.enigma.model.MovieResults
import com.test.enigma.ui.movies.detail.MovieDetailActivity
import com.test.enigma.util.ID_ARGS
import com.test.enigma.util.ViewStateModel
import kotlinx.android.synthetic.main.activity_movie_list.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MovieListActivity : BaseKoinActivityBinding<ActivityMovieListBinding>(), MovieListListener {
    internal val movieListViewModel: MovieListViewModel by inject {
        parametersOf(this)
    }

    val movieListAdapter: MovieListAdapter by inject {
        parametersOf(this)
    }

    var id = 0
    var page = 1

    override val bindingInflater: (LayoutInflater) -> ActivityMovieListBinding
        get() = ActivityMovieListBinding::inflate

    override fun setupView(binding: ActivityMovieListBinding) {

        id = intent.getIntExtra(ID_ARGS, 0)

        setupRecyclerView()

        initEvent(binding)
        initObserver()

        movieListViewModel.getMovieList(id, page)
    }

    private fun initObserver() {
        movieListViewModel.movieListLiveData.observe(this@MovieListActivity)
        {
            if (page > 1) {
                movieListAdapter.addList(it.results)
            } else
                movieListAdapter.updateList(it.results)

            page += 1
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

    override fun onMovieListClick(item: MovieResults) {
        val intent = Intent(this@MovieListActivity, MovieDetailActivity::class.java)
        intent.putExtra(ID_ARGS, item.id)
        startActivity(intent)
    }
}