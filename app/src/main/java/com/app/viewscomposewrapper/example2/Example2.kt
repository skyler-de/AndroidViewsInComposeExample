package com.app.viewscomposewrapper.example2

import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

/**
 * Example 2
 */
@Composable
fun TextViewComposable(text: String, @ColorInt color: Int) {
    AndroidView(
        factory = { context ->
            val textView = TextView(context)
            textView.text = text
            textView.setTextColor(color)
            textView
        }
    )
}