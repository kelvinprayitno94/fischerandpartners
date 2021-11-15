package com.test.enigma.util

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

enum class DividerType {
    SPACE_AROUND, SPACE_BETWEEN
}

class ItemDividerVertical(
    context: Context,
    space: Int = 16,
    private val type: DividerType = DividerType.SPACE_BETWEEN
) : RecyclerView.ItemDecoration() {
    private val spaceInDp = ConvertUtil.dpToPx(context, space)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if ((type == DividerType.SPACE_AROUND && parent.getChildAdapterPosition(view) + 1 == parent.adapter?.itemCount) || (type == DividerType.SPACE_BETWEEN && parent.getChildAdapterPosition(
                view
            ) + 1 != parent.adapter?.itemCount)
        )
            outRect.bottom = spaceInDp
        if (parent.getChildAdapterPosition(view) == 0 && type == DividerType.SPACE_AROUND)
            outRect.top = spaceInDp
    }
}

class ItemDividerHorizontal(
    context: Context,
    space: Int = 16,
    private val type: DividerType = DividerType.SPACE_BETWEEN
) : RecyclerView.ItemDecoration() {
    private val spaceInDp = ConvertUtil.dpToPx(context, space)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if ((type == DividerType.SPACE_AROUND && parent.getChildAdapterPosition(view) + 1 == parent.adapter?.itemCount) || (type == DividerType.SPACE_BETWEEN && parent.getChildAdapterPosition(
                view
            ) + 1 != parent.adapter?.itemCount)
        )
            outRect.right = spaceInDp
        if (parent.getChildAdapterPosition(view) == 0 && type == DividerType.SPACE_AROUND)
            outRect.left = spaceInDp
    }
}