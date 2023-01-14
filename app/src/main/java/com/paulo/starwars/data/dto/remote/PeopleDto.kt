package com.paulo.starwars.data.dto.remote

import com.google.gson.annotations.SerializedName
import com.paulo.starwars.domain.models.Films
import com.paulo.starwars.domain.models.People

data class PeopleDto(
    @SerializedName("hair_color")
    val hairColor: String?,
    @SerializedName("skin_color")
    val skinColor: String?,
    @SerializedName("eye_color")
    val eyeColor: String?,
    @SerializedName("birth_year")
    val birthYear: String?,

    val name: String?,
    val height: String?,
    val mass: String?,
    val gender: String?,
    val homeworld: String?,
    val created: String?,
    val edited: String?,
    val url: String?,

    val films: List<String>?,
    val species: List<String>?,
    val vehicles: List<String>?,
    val starships: List<String>?,
) {
    fun toDomain() = People(
        birthYear?: "",
        eyeColor?: "" ,
        gender?: "",
        hairColor?: "",
        height?: "",
        homeworld?: "",
        mass?: "",
        name?: "",
        skinColor?: "",
        created?: "",
        edited?: "",
        url?: "",
        films = if(films.isNullOrEmpty()) emptyList() else films ,
        species= if(species.isNullOrEmpty()) emptyList() else species ,
        starships= if(starships.isNullOrEmpty()) emptyList() else starships ,
        vehicles= if(vehicles.isNullOrEmpty()) emptyList() else vehicles ,
    )
}