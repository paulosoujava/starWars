package com.paulo.starwars.domain.models

data class Films(

    val created: String,
    val director: String,
    val edited: String,
    val episodeID: String,
    val openingCrawl: String,
    val producer: String,
    val releaseDate: String,
    val title: String,
    val url: String,

    val characters: List<String>,
    val planets: List<String>,
    val species: List<String>,
    val starships: List<String>,
    val vehicles: List<String>
)
