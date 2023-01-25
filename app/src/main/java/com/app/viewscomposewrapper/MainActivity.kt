package com.app.viewscomposewrapper

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.app.viewscomposewrapper.example5.TextViewComposable
import com.app.viewscomposewrapper.ui.theme.ViewsComposeWrapperTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewsComposeWrapperTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ParentComposable()
                }
            }
        }
    }
}

@Composable
fun ParentComposable() {
    var text by remember { mutableStateOf("initial text") }
    var textSize by remember { mutableStateOf(40F) }
    var textColor by remember { mutableStateOf(colors[0]) }
    val remoteController by remember { mutableStateOf(RemoteTextViewController()) }

    Column {
        TextField(value = text, onValueChange = { text = it })
        Row {
            Button(onClick = { if (textSize > 1) textSize-- }) {
                Text("-")
            }
            Button(onClick = { textSize++ }) {
                Text("+")
            }
            Button(onClick = { textColor = colors[Random.nextInt(colors.size)] }) {
                Text(text = "Color")
            }
        }
        Row {
            Button(onClick = { remoteController.rotateX() }) {
                Text(text = "Rot X")
            }
            Button(onClick = { remoteController.rotateY() }) {
                Text(text = "Rot Y")
            }
            Button(onClick = { remoteController.reset() }) {
                Text(text = "Reset")
            }
        }
        /**
         * Example 5 composable
         */
        TextViewComposable(
            text = text,
            color = textColor,
            textSize = textSize,
            textShadowRadius = 10f,
            textShadowDx = 10f,
            textShadowDy = 10f,
            remoteController = remoteController,
            onAbracadabra = {
                text = it
            })
    }
}

val colors = listOf(
    Color.parseColor("#FFFFFF"),
    Color.parseColor("#0000FF"),
    Color.parseColor("#00FF00"),
    Color.parseColor("#FF0000")
)
