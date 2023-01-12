package com.paulo.starwars.data.dto.remote

import com.google.gson.annotations.SerializedName
import com.paulo.starwars.domain.models.Planets

data class PlanetsDto(
    val climate: String,
    val created: String,
    val diameter: String,
    val edited: String,
    val gravity: String,
    val name: String,
    @SerializedName("orbital_period")
    val orbitalPeriod: String,
    val population: String,
    @SerializedName("rotation_period")
    val rotationPeriod: String,
    @SerializedName("rotation_period")
    val surface_water: String,
    val terrain: String,
    val url: String,

    val films: List<FilmsDto>,
    val residents: List<PeopleDto>,
){
    fun toDomain() = Planets(
        climate,
        created,
        diameter,
        edited,
        gravity,
        name,
        orbitalPeriod,
        population,
        rotationPeriod,
        surface_water,
        terrain,
        url,
        films =  emptyList(),
        residents =  residents.map { it.toDomain() },
    )
}
