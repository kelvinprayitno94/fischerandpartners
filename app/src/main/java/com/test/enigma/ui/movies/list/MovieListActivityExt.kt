package com.test.enigma.ui.movies.list

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_movie_list.*


fun MovieListActivity.setupRecyclerView() {
    recyclerViewMovieList.run {
        adapter = movieListAdapter
        layoutManager =
            LinearLayoutManager(this@setupRecyclerView, LinearLayoutManager.VERTICAL, false)
    }

    recyclerViewMovieList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (!recyclerView.canScrollVertically(1)) {
                movieListViewModel.getMovieList(id, page = page)
            }
        }
    })
}