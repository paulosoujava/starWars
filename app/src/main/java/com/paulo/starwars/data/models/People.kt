package com.paulo.starwars.data.models

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
    val films: List<Films>,
    val species: List<Species>,
    val starships: List<Starships>,
    val vehicles: List<Vehicles>
)