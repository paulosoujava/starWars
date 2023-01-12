package com.paulo.starwars.domain.models

data class Starships(
    val mglt: String,
    val cargoCapacity: String,
    val consumables: String,
    val costInCredits: String,
    val created: String,
    val crew: String,
    val edited: String,
    val hyperdriveRating: String,
    val length: String,
    val manufacturer: String,
    val maxAtmospheringSpeed: String,
    val model: String,
    val name: String,
    val passengers: String,
    val starshipClass: String,
    val url: String,

    val films: List<Films>,
    val pilots: List<People?>,
)
