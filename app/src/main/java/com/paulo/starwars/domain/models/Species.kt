package com.paulo.starwars.domain.models

data class Species(
    val averageHeight: String,
    val averageLifespan: String,
    val classification: String,
    val created: String,
    val designation: String,
    val edited: String,
    val eyeColors: String,
    val hairColors: String,
    val homeworld: String,
    val language: String,
    val name: String,
    val skinColors: String,
    val url: String,

    val people: List<People>,
    val films: List<Films>,
)
