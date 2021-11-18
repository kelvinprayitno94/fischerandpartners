package com.test.enigma.ui.movies.category

import android.content.Intent
import android.view.LayoutInflater
import android.widget.Toast
import com.test.enigma.base.BaseKoinActivityBinding
import com.test.enigma.base.setGone
import com.test.enigma.base.setVisible
import com.test.enigma.databinding.ActivityMovieCategoryBinding
import com.test.enigma.model.Genres
import com.test.enigma.ui.movies.list.MovieListActivity
import com.test.enigma.util.ID_ARGS
import com.test.enigma.util.ViewStateModel
import kotlinx.android.synthetic.main.activity_movie_category.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MovieCategoriesActivity : BaseKoinActivityBinding<ActivityMovieCategoryBinding>(),
    MovieCategoryListener {
    private val movieCategoriesViewModel: MovieCategoriesViewModel by inject {
        parametersOf(this)
    }

    val movieCategoryAdapter: MovieCategoryAdapter by inject {
        parametersOf(this)
    }

    override val bindingInflater: (LayoutInflater) -> ActivityMovieCategoryBinding
        get() = ActivityMovieCategoryBinding::inflate

    override fun setupView(binding: ActivityMovieCategoryBinding) {

        setupRecyclerView()

        initEvent(binding)
        initObserver()

        movieCategoriesViewModel.getMovieCategory()
    }

    private fun initObserver() {
        movieCategoriesViewModel.movieCategoryLiveData.observe(this@MovieCategoriesActivity)
        {
            movieCategoryAdapter.updateList(it.genres)
        }

        movieCategoriesViewModel.viewStateLiveData.observe(this@MovieCategoriesActivity)
        {
            when (it) {
                ViewStateModel.LOADING -> {
                    progressBarMovieCategory.setVisible()
                }
                ViewStateModel.FAILED -> {
                    progressBarMovieCategory.setGone()
                }
                ViewStateModel.SUCCESS -> {
                    progressBarMovieCategory.setGone()
                }
            }
        }
    }

    private fun initEvent(binding: ActivityMovieCategoryBinding) {


    }

    override fun onMovieCategoryClick(item: Genres) {
        val intent = Intent(this@MovieCategoriesActivity, MovieListActivity::class.java)
        intent.putExtra(ID_ARGS, item.id)
        startActivity(intent)
    }
}