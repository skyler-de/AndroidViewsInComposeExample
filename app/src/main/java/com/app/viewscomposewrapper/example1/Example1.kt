package com.app.viewscomposewrapper.example1

import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

/**
 * Example 1
 */
@Composable
fun TextViewComposable() {
    AndroidView(
        factory = { context ->
            TextView(context)
        }
    )
}