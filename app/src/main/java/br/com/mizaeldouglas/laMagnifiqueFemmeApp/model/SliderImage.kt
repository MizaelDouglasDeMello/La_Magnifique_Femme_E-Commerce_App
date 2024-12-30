package br.com.mizaeldouglas.laMagnifiqueFemmeApp.model

import br.com.mizaeldouglas.laMagnifiqueFemmeApp.R

data class SliderImage(
    val image: Int
)

val dummySliderImage = listOf(
    SliderImage(R.drawable.image_slider_one),
    SliderImage(R.drawable.image_slider_two),
    SliderImage(R.drawable.image_slider_three),
    SliderImage(R.drawable.image_slider_four),
)