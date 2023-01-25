package com.app.viewscomposewrapper.util

import android.widget.TextView
import kotlin.random.Random

interface AbracadabraListener {
    fun onAbracadabra(newText: CharSequence)
}

/**
 * TextView extension function for
 * switching text to a random word
 */
fun TextView.abracadabra() {
    text = randomWords[Random.nextInt(randomWords.size)]
    abracadabraListener(text)
}

/**
 * TextView extension function for
 * rotating the text on its X axis
 */
fun TextView.rotateX() {
    rotationX += 10F
}

/**
 * TextView extension function for
 * rotating the text on its Y axis
 */
fun TextView.rotateY() {
    rotationY += 10F
}

/**
 * TextView extension function for
 * rotating the text on its X axis
 */
fun TextView.reset() {
    rotationX = 0F
    rotationY = 0F

}

/**
 * Listener for when abracadabra function
 * is called
 */
var _abracadabraListener: (CharSequence) -> Unit = {}
var TextView.abracadabraListener: (CharSequence) -> Unit
    get() = _abracadabraListener
    set(value) {
        _abracadabraListener = value
    }


/**
 * List of random words for
 */
val TextView.randomWords: List<String>
    get() = listOf(
        "Elixir",
        "Gazebo",
        "Quandary",
        "Saunter",
        "Lavender",
        "Serendipity",
        "Serene",
        "Harmony",
        "Effervesce",
        "Luminous",
        "Gossamer",
        "Serendipitous",
        "Gossamer",
        "Halcyon",
        "Effervescent",
        "Luminous",
        "Enigma",
        "Ethereal",
        "Effervescent",
        "Luminous"
    )
