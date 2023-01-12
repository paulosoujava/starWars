package com.paulo.starwars.data

import com.paulo.starwars.data.dto.remote.HomeDto
import com.paulo.starwars.utils.Constants

class Api {
    fun getHome() = listOf(
        HomeDto(
            url = "${Constants.URL_BASE_TO_IMAGE}/${Constants.CHARACTERS }.jpg",
            title = Constants.CHARACTERS.uppercase()
        ),
        HomeDto(
            url = "${Constants.URL_BASE_TO_IMAGE}/${Constants.FILMS }.jpg",
            title = Constants.FILMS.uppercase()
        ),
        HomeDto(
            url = "${Constants.URL_BASE_TO_IMAGE}/${Constants.SPECIES }.jpg",
            title = Constants.SPECIES.uppercase()
        ),
        HomeDto(
            url = "${Constants.URL_BASE_TO_IMAGE}/${Constants.VEHICLES }.jpg",
            title = Constants.VEHICLES.uppercase()
        ),
        HomeDto(
            url = "${Constants.URL_BASE_TO_IMAGE}/${Constants.PLANETS }.jpg",
            title = Constants.PLANETS.uppercase()
        ),HomeDto(
            url = "${Constants.URL_BASE_TO_IMAGE}/${Constants.STARSHIPS }.jpg",
            title = Constants.STARSHIPS.uppercase()
        )
    )
}
