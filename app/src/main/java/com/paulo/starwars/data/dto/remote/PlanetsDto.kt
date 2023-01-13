package com.paulo.starwars.data.dto.remote

import com.google.gson.annotations.SerializedName
import com.paulo.starwars.domain.models.Planets

data class PlanetsDto(

    @SerializedName("rotation_period")
    val rotationPeriod: String?,
    @SerializedName("surface_water")
    val surfaceWater: String?,
    @SerializedName("orbital_period")
    val orbitalPeriod: String?,

    val name: String?,
    val diameter: String?,
    val climate: String?,
    val gravity: String?,
    val terrain: String?,
    val population: String?,
    val created: String?,
    val edited: String?,
    val url: String?,


    val residents: List<String>?,
    val films: List<String>?,

){
    fun toDomain() = Planets(
        climate?: "",
        created?: "",
        diameter?: "",
        edited?: "",
        gravity?: "",
        name?: "",
        orbitalPeriod?: "",
        population?: "",
        rotationPeriod?: "",
        surfaceWater?: "",
        terrain?: "",
        url?: "",
        films =  if(films.isNullOrEmpty()) emptyList() else films ,
        residents =  if(residents.isNullOrEmpty()) emptyList() else residents ,
    )
}
