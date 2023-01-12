package com.paulo.starwars.domain.models

data class Films(

    val created: String,
    val director: String,
    val edited: String,
    val episodeID: Long,
    val openingCrawl: String,
    val producer: String,
    val releaseDate: String,
    val title: String,
    val url: String,

    val characters: List<People>,
    val planets: List<Planets>,
    val species: List<Species>,
    val starships: List<Starships>,
    val vehicles: List<Vehicles>
)
