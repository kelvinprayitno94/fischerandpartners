package com.test.enigma.ui.movies.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.enigma.R
import com.test.enigma.base.loadImageFullUrl
import com.test.enigma.base.loadImageUrl
import com.test.enigma.model.MovieReviewResults
import kotlinx.android.synthetic.main.adapter_movie_review.view.*

class MovieReviewAdapter(val context: Context) :
    RecyclerView.Adapter<MovieReviewAdapter.ViewHolder>() {
    var list: MutableList<MovieReviewResults> = arrayListOf()

    fun updateList(_list: List<MovieReviewResults>) {
        list.clear()
        list.addAll(_list)

        notifyDataSetChanged()
    }

    fun addList(_list: List<MovieReviewResults>) {
        list.addAll(_list)

        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_movie_review, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(context: Context, item: MovieReviewResults) {
            if (!item.authorDetails.avatarPath.contains("http")) {
                itemView.textViewMovieReviewAvatar.loadImageUrl(
                    item.authorDetails.avatarPath,
                    context
                )
            }
//            else
//                itemView.textViewMovieReviewAvatar.loadImageUrl(
//                    item.authorDetails.avatarPath,
//                    context
//                )
            itemView.textViewMovieReviewAuthor.text = item.author
            itemView.textViewMovieReviewContent.text = item.content
        }
    }
}