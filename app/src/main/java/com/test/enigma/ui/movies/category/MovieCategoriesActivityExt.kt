package com.test.enigma.ui.movies.category

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movie_category.*

fun MovieCategoriesActivity.setupRecyclerView() {
    recyclerViewMovieCategory.run {
        adapter = movieCategoryAdapter
        layoutManager =
            LinearLayoutManager(this@setupRecyclerView, LinearLayoutManager.VERTICAL, false)
    }
}