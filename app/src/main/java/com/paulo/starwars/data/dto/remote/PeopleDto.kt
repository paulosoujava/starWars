package com.paulo.starwars.data.dto.remote

import com.google.gson.annotations.SerializedName
import com.paulo.starwars.domain.models.Films
import com.paulo.starwars.domain.models.People


data class PeopleDto(
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("eye_color")
    val eyeColor: String,
    @SerializedName("hair_color")
    val hairColor: String,
    val name: String,
    @SerializedName("skin_color")
    val gender: String,

    val height: String,
    val homeworld: String,
    val mass: String,
    val skinColor: String,
    val created: String,
    val edited: String,
    val url: String,
    val films: List<FilmsDto>,
    val species: List<SpeciesDto>,
    val starships: List<StarshipsDto>,
    val vehicles: List<VehiclesDto>
) {
    fun toDomain() = People(
        birthYear = this.birthYear,
        eyeColor = this.eyeColor,
        gender = this.gender,
        hairColor = this.hairColor,
        height = this.height,
        homeworld = this.homeworld,
        mass = this.mass,
        name = this.name,
        skinColor = this.skinColor,
        created = this.created,
        edited = this.edited,
        url = this.url,
        //films =  films.map { it.toDomain() },
        films = emptyList(),
        species =  species.map { it.toDomain() },
        starships =  starships.map { it.toDomain() },
        vehicles =  vehicles.map { it.toDomain() },
    )
}