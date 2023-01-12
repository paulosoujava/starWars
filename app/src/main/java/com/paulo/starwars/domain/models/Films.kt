package com.paulo.starwars.domain.models

data class Films(
    val consumables: String,
    val costInCredits: String,
    val created: String,
    val crew: String,
    val edited: String,
    val length: String,
    val manufacturer: String,
    val maxAtmospheringSpeed: String,
    val model: String,
    val name: String,
    val passengers: String,
    val url: String,

    val pilots: List<People>,
    val films: List<Films>,
    val vehicleClass: String
)
