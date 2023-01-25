package com.app.viewscomposewrapper.example4

import android.graphics.Color
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.app.viewscomposewrapper.RemoteTextViewController
import com.app.viewscomposewrapper.util.*

/**
 * Example 4
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
    val currentText by rememberUpdatedState(newValue = text)
    val currentColor by rememberUpdatedState(newValue = color)
    val currentTextSize by rememberUpdatedState(newValue = textSize)
    val currentTextShadowRadius by rememberUpdatedState(newValue = textShadowRadius)
    val currentTextShadowDx by rememberUpdatedState(newValue = textShadowDx)
    val currentTextShadowDy by rememberUpdatedState(newValue = textShadowDy)
    val currentTextShadowColor by rememberUpdatedState(newValue = textShadowColor)
    val currentRemoteController by rememberUpdatedState(newValue = remoteController)

    AndroidView(
        modifier = modifier,
        factory = { context ->
            val textView = TextView(context)
            textView.abracadabraListener = { newText -> onAbracadabra(newText.toString()) }
            currentRemoteController.addListener(
                "TextViewWrapper",
                object : RemoteTextViewController.RemoteTextViewControllerListener {
                    override fun onRotateX() {
                        textView.rotateX()
                    }

                    override fun onRotateY() {
                        textView.rotateY()
                    }

                    override fun onReset() {
                        textView.reset()
                    }

                })
            // ignore this line,
            textView.setOnClickListener { textView.abracadabra() }
            textView
        },
        update = { textView ->
            textView.text = currentText
            textView.textSize = currentTextSize
            textView.setShadowLayer(
                currentTextShadowRadius,
                currentTextShadowDx,
                currentTextShadowDy,
                currentTextShadowColor
            )
            textView.setTextColor(currentColor)
        }
    )
}


