package com.app.viewscomposewrapper

import android.widget.TextView
import com.app.viewscomposewrapper.util.*

class RemoteTextViewController {
    interface RemoteTextViewControllerListener {
        fun onRotateX()
        fun onRotateY()
        fun onReset()
    }

    private val listeners: MutableMap<String, RemoteTextViewControllerListener> = mutableMapOf()

    fun rotateX() {
        listeners.values.forEach { it.onRotateX() }
    }

    fun rotateY() {
        listeners.values.forEach { it.onRotateY() }
    }

    fun reset() {
        listeners.values.forEach { it.onReset() }
    }

    fun addListener(key: String, value: RemoteTextViewControllerListener) {
        if (!listeners.containsKey(key)) {
            listeners[key] = value
        }
    }

    fun removeListener(key: String) {
        listeners.remove(key)
    }
}

class TextViewUpdater(
    val textView: TextView,
    remoteTextViewController: RemoteTextViewController? = null,
    var abracadabraListener: (String) -> Unit = {}
) {

    init {
        textView.abracadabraListener = { abracadabraListener(it.toString()) }
        textView.setOnClickListener { textView.abracadabra() }
        remoteTextViewController?.addListener("TextViewController", object :
            RemoteTextViewController.RemoteTextViewControllerListener {
            override fun onRotateX() {
                rotateX()
            }

            override fun onRotateY() {
                rotateY()
            }

            override fun onReset() {
                reset()
            }
        })
    }

    fun update(
        text: String,
        textSize: Float,
        color: Int,
        textShadowRadius: Float,
        textShadowDx: Float,
        textShadowDy: Float,
        textShadowColor: Int
    ) {
        textView.text = text
        textView.textSize = textSize
        textView.setShadowLayer(
            textShadowRadius,
            textShadowDx,
            textShadowDy,
            textShadowColor
        )
        textView.setTextColor(color)
    }

    private fun rotateX() {
        textView.rotateX()
    }

    private fun rotateY() {
        textView.rotateY()
    }

    private fun reset() {
        textView.reset()
    }
}
