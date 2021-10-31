package uz.example.ecovent.Model

import java.io.Serializable

data class ImageModel(
        val image: Int,
        val imageName: String,
        val edTHint: List<String>,
        val degree: Boolean = false,
        val edText0: Boolean = false,
        val edText1: Boolean = false,
        val edText2: Boolean = false,
        val edText3: Boolean = false,
        val edText4: Boolean = false,
        val edText5: Boolean = false
): Serializable
