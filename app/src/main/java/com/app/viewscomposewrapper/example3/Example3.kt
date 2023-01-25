package com.app.viewscomposewrapper.example3

import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.viewinterop.AndroidView

/**
 * Example 3
 */
@Composable
fun TextViewComposable(text: String, @ColorInt color: Int) {

    val currentText by rememberUpdatedState(newValue = text)
    val currentColor by rememberUpdatedState(newValue = color)

    AndroidView(
        factory = { context ->
            val textView = TextView(context)
            textView.textSize = 30f
            textView
        },
        update = { textView ->
            textView.text = currentText
            textView.setTextColor(currentColor)
        }
    )
}
