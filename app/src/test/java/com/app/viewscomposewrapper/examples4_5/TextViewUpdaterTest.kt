package com.app.viewscomposewrapper.examples4_5

import android.widget.TextView
import com.app.viewscomposewrapper.RemoteTextViewController
import com.app.viewscomposewrapper.TextViewUpdater
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class TextViewUpdaterTest() {

    @Mock
    lateinit var textView: TextView

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `TextView SetShadowLayer() is called when when view is updated`() {
        val updater = TextViewUpdater(
            textView = textView,
            remoteTextViewController = RemoteTextViewController()
        )

        updater.update(
            "newText",
            10f,
            0,
            10f,
            10f,
            10f,
            10
        )

        verify(textView, times(1)).setShadowLayer(10f, 10f, 10f, 10)
    }
}