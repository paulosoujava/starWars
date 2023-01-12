package com.paulo.starwars.data.dto.remote

import com.google.gson.annotations.SerializedName
import com.paulo.starwars.domain.models.Films

data class FilmsDto(
    val created: String,
    val director: String,
    val edited: String,
    @SerializedName("episode_id")
    val episodeID: Long,
    @SerializedName("opening_crawl")
    val openingCrawl: String,
    val producer: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val url: String,

    val characters: List<PeopleDto>,
    val planets: List<PlanetsDto>,
    val species: List<SpeciesDto>,
    val starships: List<StarshipsDto>,
    val vehicles: List<VehiclesDto>
) {

    fun toDomain() = Films(
        created,
        director,
        edited,
        episodeID,
        openingCrawl,
        producer,
        releaseDate,
        title,
        url,
        //characters = characters.map { it.toDomain() },
        planets = planets.map { it.toDomain() },
        starships = starships.map { it.toDomain() },
        vehicles = vehicles.map { it.toDomain() },
        //species = species.map { it.toDomain() },
        characters = emptyList(),
        species = emptyList()
    )
}
