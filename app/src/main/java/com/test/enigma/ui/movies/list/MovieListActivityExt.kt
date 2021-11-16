package com.test.enigma.ui.movies.list

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movie_list.*

fun MovieListActivity.setupRecyclerView() {
    recyclerViewMovieList.run {
        adapter = movieListAdapter
        layoutManager =
            LinearLayoutManager(this@setupRecyclerView, LinearLayoutManager.HORIZONTAL, false)
    }
}