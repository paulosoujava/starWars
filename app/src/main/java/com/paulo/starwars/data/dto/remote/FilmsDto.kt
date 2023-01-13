package com.paulo.starwars.data.dto.remote

import com.google.gson.annotations.SerializedName
import com.paulo.starwars.domain.models.Films

data class FilmsDto(

    @SerializedName("episode_id")
    val episodeID: String?,
    @SerializedName("opening_crawl")
    val openingCrawl: String?,
    @SerializedName("release_date")
    val releaseDate: String?,

    val director: String?,
    val producer: String?,
    val title: String?,
    val created: String?,
    val edited: String?,
    val url: String?,

    val characters: List<String>?,
    val planets: List<String>?,
    val starships: List<String>?,
    val vehicles: List<String>?,
    val species: List<String>?,

) {

    fun toDomain() = Films(
        created ?:"",
        director?:"",
        edited?:"",
        episodeID ?: "",
        openingCrawl?:"",
        producer?:"",
        releaseDate?:"",
        title?:"",
        url?:"",
        characters  = if(characters.isNullOrEmpty()) emptyList() else characters ,
        planets =  if(planets.isNullOrEmpty()) emptyList() else planets ,
        starships =  if(starships.isNullOrEmpty()) emptyList() else starships ,
        vehicles =  if(vehicles.isNullOrEmpty()) emptyList() else vehicles ,
        species =  if(species.isNullOrEmpty()) emptyList() else species ,

    )
}
