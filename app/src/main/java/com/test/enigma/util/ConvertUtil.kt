package com.test.enigma.util

import android.content.Context
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class ConvertUtil {
    companion object {
        fun dpToPx(context: Context, dp: Int): Int {
            return (dp * context.resources.displayMetrics.density).toInt()
        }

        fun spToPx(context: Context, sp: Int): Int {
            return (sp * context.resources.displayMetrics.scaledDensity).toInt()
        }

        fun toCurrency(value: Int): String? {
            val separator = DecimalFormatSymbols()
            separator.decimalSeparator = ','
            separator.groupingSeparator = '.'
            val formatter = DecimalFormat("#,###,###", separator)
            return formatter.format(value)
        }
    }
}