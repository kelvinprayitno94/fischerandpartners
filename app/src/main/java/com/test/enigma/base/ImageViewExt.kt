package com.test.enigma.base

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.test.enigma.R
import com.test.enigma.util.IMAGE_URL

fun ImageView.loadImageUrl(url: String? = "", context: Context) {
    Glide.with(context)
        .load("$IMAGE_URL${url}")
        .error(R.drawable.ic_image_not_found)
        .into(this)
}

fun ImageView.loadImageFullUrl(url: String, context: Context) {
    Glide.with(context)
        .load(url)
        .error(R.drawable.ic_image_not_found)
        .into(this)
}
