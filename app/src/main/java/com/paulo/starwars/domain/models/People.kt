package com.paulo.starwars.domain.models

data class People(
    val birthYear: String,
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val skinColor: String,
    val created: String,
    val edited: String,
    val url: String,

    val films: List<String>,
    val species: List<String>,
    val starships: List<String>,
    val vehicles: List<String>
)