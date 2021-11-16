package com.test.enigma.ui.movies.category

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movie_list.*

fun MovieCategoriesActivity.setupRecyclerView() {
    recyclerViewMovieCategory.run {
        adapter = movieCategoryAdapter
        layoutManager =
            LinearLayoutManager(this@setupRecyclerView, LinearLayoutManager.HORIZONTAL, false)
    }
}