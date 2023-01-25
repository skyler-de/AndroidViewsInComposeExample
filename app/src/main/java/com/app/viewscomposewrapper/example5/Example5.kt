package com.app.viewscomposewrapper.example5

import android.graphics.Color
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.app.viewscomposewrapper.RemoteTextViewController
import com.app.viewscomposewrapper.TextViewUpdater

/**
 * Example 5
 */
@Composable
fun TextViewComposable(
    modifier: Modifier = Modifier,
    text: String,
    @ColorInt color: Int = Color.parseColor("#FF0000"),
    textSize: Float = 30F,
    textShadowRadius: Float = 0F,
    textShadowDx: Float = 0F,
    textShadowDy: Float = 0F,
    @ColorInt textShadowColor: Int = Color.parseColor("#0000FF"),
    remoteController: RemoteTextViewController,
    onAbracadabra: (String) -> Unit = {}
) {
    val context = LocalContext.current

    val textViewUpdater by remember {
        mutableStateOf(TextViewUpdater(TextView(context), remoteController, onAbracadabra))
    }

    val currentText by rememberUpdatedState(newValue = text)
    val currentColor by rememberUpdatedState(newValue = color)
    val currentTextSize by rememberUpdatedState(newValue = textSize)
    val currentTextShadowRadius by rememberUpdatedState(newValue = textShadowRadius)
    val currentTextShadowDx by rememberUpdatedState(newValue = textShadowDx)
    val currentTextShadowDy by rememberUpdatedState(newValue = textShadowDy)
    val currentTextShadowColor by rememberUpdatedState(newValue = textShadowColor)

    AndroidView(
        modifier = modifier,
        factory = {
            textViewUpdater.textView
        },
        update = {
            textViewUpdater.update(
                currentText,
                currentTextSize,
                currentColor,
                currentTextShadowRadius,
                currentTextShadowDx,
                currentTextShadowDy,
                currentTextShadowColor
            )
        }
    )
}
