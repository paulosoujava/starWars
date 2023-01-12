package com.paulo.starwars.data.models

data class Planet(
    val climate: String,
    val created: String,
    val diameter: String,
    val edited: String,
    val gravity: String,
    val name: String,
    val orbitalPeriod: String,
    val population: String,
    val rotationPeriod: String,
    val surfaceWater: String,
    val terrain: String,
    val url: String,

    val films: List<Films>,
    val residents: List<People>,
)
