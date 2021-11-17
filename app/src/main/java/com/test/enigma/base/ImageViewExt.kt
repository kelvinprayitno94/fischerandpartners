package com.test.enigma.base

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.test.enigma.R
import com.test.enigma.util.IMAGE_URL
import kotlinx.android.synthetic.main.adapter_movie_list.view.*

fun ImageView.loadImageUrl(url: String, context: Context) {
    Glide.with(context)
        .load(url)
        .load("$IMAGE_URL${url}")
        .error(R.drawable.ic_image_not_found)
        .into(this)
}