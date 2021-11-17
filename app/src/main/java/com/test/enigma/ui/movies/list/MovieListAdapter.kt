package com.test.enigma.ui.movies.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.enigma.R
import com.test.enigma.base.loadImageUrl
import com.test.enigma.model.MovieItems
import com.test.enigma.util.HEAD_URL
import com.test.enigma.util.IMAGE_URL
import kotlinx.android.synthetic.main.adapter_movie_list.view.*

interface MovieListListener {
    fun onMovieListClick(item: MovieItems)
}

class MovieListAdapter(
    private val context: Context,
    private val movieCategoryListener: MovieListListener
) :
    RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    var list: MutableList<MovieItems> = arrayListOf()

    fun updateList(_list: List<MovieItems>) {
        list.clear()
        list.addAll(_list)

        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_movie_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, list[position], movieCategoryListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(context: Context, item: MovieItems, movieCategoryListener: MovieListListener) {
            itemView.textViewMovieListPoster.loadImageUrl(item.posterPath, context)
            itemView.textViewMovieListTitle.text = item.title
            itemView.textViewMovieListOverview.text = item.overview
            itemView.textViewMovieListReleaseDate.text = item.releaseDate

            itemView.setOnClickListener {
                movieCategoryListener.onMovieListClick(item)
            }
        }
    }
}