package com.test.enigma.ui.movies.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.enigma.R
import com.test.enigma.model.Genres
import kotlinx.android.synthetic.main.adapter_movie_category.view.*

interface MovieCategoryListener{
    fun onMovieCategoryClick(item: Genres)
}

class MovieCategoryAdapter(private val movieCategoryListener: MovieCategoryListener):
    RecyclerView.Adapter<MovieCategoryAdapter.ViewHolder>() {
    var list: MutableList<Genres> = arrayListOf()

    fun updateList(_list: List<Genres>) {
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
        holder.bind(list[position], movieCategoryListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Genres, movieCategoryListener: MovieCategoryListener) {
            itemView.textViewCategoryId.text = item.id.toString()
            itemView.textViewCategoryName.text = item.name

            itemView.setOnClickListener {
                movieCategoryListener.onMovieCategoryClick(item)
            }
        }
    }
}