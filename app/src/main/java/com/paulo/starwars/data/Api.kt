package com.paulo.starwars.data

import com.paulo.starwars.data.dto.remote.HomeDto
import com.paulo.starwars.domain.models.Films
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.models.Planets
import com.paulo.starwars.domain.models.Species
import com.paulo.starwars.domain.models.Starships
import com.paulo.starwars.domain.models.Vehicles
import com.paulo.starwars.utils.Constants
import retrofit2.http.GET


fun getImageHome() = listOf(
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

interface Api {
    @GET("people/")
    suspend fun getPeople(): Result<People>

    @GET("films")
    suspend fun getFilms(): Result<Films>

    @GET("planets")
    suspend fun getPlanets(): Result<Planets>

    @GET("species")
    suspend fun getSpecies(): Result<Species>

    @GET("starships")
    suspend fun getStarships(): Result<Starships>

    @GET("vehicles")
    suspend fun getVehicles(): Result<Vehicles>



}
