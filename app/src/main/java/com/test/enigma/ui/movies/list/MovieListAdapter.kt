package com.test.enigma.ui.movies.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.enigma.R
import com.test.enigma.base.loadImageUrl
import com.test.enigma.model.MovieResults
import kotlinx.android.synthetic.main.adapter_movie_list.view.*

interface MovieListListener {
    fun onMovieListClick(item: MovieResults)
}

class MovieListAdapter(
    private val context: Context,
    private val movieCategoryListener: MovieListListener
) :
    RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    var list: MutableList<MovieResults> = arrayListOf()

    fun updateList(_list: List<MovieResults>) {
        list.clear()
        list.addAll(_list)

        notifyDataSetChanged()
    }

    fun addList(_list: List<MovieResults>) {
        list.addAll(_list)

        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_movie_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, list[position], movieCategoryListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(context: Context, item: MovieResults, movieCategoryListener: MovieListListener) {
            itemView.textViewMovieListPoster.loadImageUrl(item.posterPath, context)
            itemView.textViewMovieListTitle.text = item.name
//            itemView.textViewMovieListOverview.text = item.overview
//            itemView.textViewMovieListReleaseDate.text = item.releaseDate

            itemView.setOnClickListener {
                movieCategoryListener.onMovieListClick(item)
            }
        }
    }
}