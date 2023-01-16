package com.paulo.starwars.data.framework.network.dto.remote

import com.google.gson.annotations.SerializedName
import com.paulo.starwars.domain.models.Species

data class SpeciesDto(
    @SerializedName("average_height")
    val averageHeight: String?,
    @SerializedName("average_lifespan")
    val averageLifespan: String?,
    @SerializedName("eye_colors")
    val eyeColors: String?,
    @SerializedName("hair_colors")
    val hairColors: String?,
    @SerializedName("skin_colors")
    val skinColors: String?,

    val classification: String?,
    val created: String?,
    val designation: String?,
    val edited: String?,
    val homeworld: String?,
    val language: String?,
    val name: String?,
    val url: String?,

    val people: List<String>?,
    val films: List<String>?,
) {

    fun toDomain() = Species(
        averageHeight ?: "",
        averageLifespan ?: "",
        classification ?: "",
        created ?: "",
        designation ?: "",
        edited ?: "",
        eyeColors ?: "",
        hairColors ?: "",
        homeworld ?: "",
        language ?: "",
        name ?: "",
        skinColors ?: "",
        url ?: "",
        people =  if(people.isNullOrEmpty()) emptyList() else people ,
        films =  if(films.isNullOrEmpty()) emptyList() else films ,
    )
}