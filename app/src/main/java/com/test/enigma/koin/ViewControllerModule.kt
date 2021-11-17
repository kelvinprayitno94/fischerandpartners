package com.test.enigma.koin

import com.test.enigma.ui.movies.category.MovieCategoriesActivity
import com.test.enigma.ui.movies.category.MovieCategoriesViewModel
import com.test.enigma.ui.movies.category.MovieCategoryAdapter
import com.test.enigma.ui.movies.detail.MovieDetailActivity
import com.test.enigma.ui.movies.detail.MovieDetailViewModel
import com.test.enigma.ui.movies.list.MovieListActivity
import com.test.enigma.ui.movies.list.MovieListAdapter
import com.test.enigma.ui.movies.list.MovieListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewControllerModule = module {
    scope(named<MovieCategoriesActivity>()) {
        scoped {
            MovieCategoriesViewModel(
                apiRepoContract = get()
            )
        }

        scoped { (activity: MovieCategoriesActivity) ->
            MovieCategoryAdapter(activity)
        }
    }

    scope(named<MovieListActivity>()) {
        scoped {
            MovieListViewModel(
                apiRepoContract = get()
            )
        }

        scoped { (activity: MovieListActivity) ->
            MovieListAdapter(androidContext(), activity)
        }
    }

    scope(named<MovieDetailActivity>()) {
        scoped {
            MovieDetailViewModel(
                apiRepoContract = get()
            )
        }
    }
}
