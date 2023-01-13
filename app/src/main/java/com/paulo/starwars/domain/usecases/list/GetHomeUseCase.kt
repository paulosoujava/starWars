package com.paulo.starwars.domain.usecases.list

import com.paulo.starwars.domain.models.Home
import com.paulo.starwars.utils.Constants

class GetHomeUseCase{
     operator fun invoke(): List<Home> {
        return getImageHome()
    }

    private fun getImageHome() = listOf(
        Home(
            url = "${Constants.URL_BASE_TO_IMAGE}/${Constants.CHARACTERS }.jpg",
            title = Constants.CHARACTERS.uppercase()
        ),
        Home(
            url = "${Constants.URL_BASE_TO_IMAGE}/${Constants.FILMS }.jpg",
            title = Constants.FILMS.uppercase()
        ),
        Home(
            url = "${Constants.URL_BASE_TO_IMAGE}/${Constants.SPECIES }.jpg",
            title = Constants.SPECIES.uppercase()
        ),
        Home(
            url = "${Constants.URL_BASE_TO_IMAGE}/${Constants.VEHICLES }.jpg",
            title = Constants.VEHICLES.uppercase()
        ),
        Home(
            url = "${Constants.URL_BASE_TO_IMAGE}/${Constants.PLANETS }.jpg",
            title = Constants.PLANETS.uppercase()
        ), Home(
            url = "${Constants.URL_BASE_TO_IMAGE}/${Constants.STARSHIPS }.jpg",
            title = Constants.STARSHIPS.uppercase()
        )
    )
}
