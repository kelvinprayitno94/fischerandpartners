package com.test.enigma.koin

import com.test.enigma.ui.movies.category.MovieCategoriesActivity
import com.test.enigma.ui.movies.category.MovieCategoriesViewModel
import com.test.enigma.ui.movies.category.MovieCategoryAdapter
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewControllerModule = module {
    scope(named<MovieCategoriesActivity>()) {
        scoped {
            MovieCategoriesViewModel(
                apiRepoContract = get()
            )
        }

        scoped {(activity: MovieCategoriesActivity) ->
            MovieCategoryAdapter(activity)
        }
    }
}
