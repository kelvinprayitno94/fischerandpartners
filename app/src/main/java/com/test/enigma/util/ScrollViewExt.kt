package com.test.enigma.util

import android.content.Context
import android.util.AttributeSet
import androidx.core.widget.NestedScrollView

interface ScrollViewListener {
    fun onScrollChanged(
        scrollView: ScrollViewExt?,
        x: Int, y: Int, oldx: Int, oldy: Int
    )
}

class ScrollViewExt : NestedScrollView {
    private var scrollViewListener: ScrollViewListener? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    fun setScrollViewListener(scrollViewListener: ScrollViewListener?) {
        this.scrollViewListener = scrollViewListener
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        scrollViewListener?.onScrollChanged(this, l, t, oldl, oldt)
    }
}