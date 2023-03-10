package com.paulo.starwars.domain.models

import com.google.gson.annotations.SerializedName

data class People(
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("eye_color")
    val eyeColor: String,
    @SerializedName("skin_color")
    val skinColor: String,
    @SerializedName("hair_color")
    val hairColor: String,

    val gender: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val created: String,
    val edited: String,
    val url: String,


    val films: List<String>,
    val species: List<String>,
    val starships: List<String>,
    val vehicles: List<String>
)