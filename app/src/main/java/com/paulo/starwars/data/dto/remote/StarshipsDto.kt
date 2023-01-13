package com.paulo.starwars.data.dto.remote

import com.google.gson.annotations.SerializedName
import com.paulo.starwars.domain.models.Films
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.models.Starships

data class StarshipsDto(
    val mglt: String?,
    @SerializedName("cargo_capacity")
    val cargoCapacity: String?,
    val consumables: String?,
    @SerializedName("cost_in_credits")
    val costInCredits: String?,
    @SerializedName("hyperdrive_rating")
    val hyperdriveRating: String?,
    @SerializedName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String?,
    @SerializedName("starship_class")
    val starshipClass: String?,

    val created: String?,
    val crew: String?,
    val edited: String?,
    val length: String?,
    val manufacturer: String?,
    val model: String?,
    val name: String?,
    val passengers: String?,
    val url: String?,

    val films: List<String>?,
    val pilots: List<String>?,
) {

    fun toDomain() = Starships(
        mglt ?: "",
        cargoCapacity ?: "",
        consumables ?: "",
        costInCredits ?: "",
        created ?: "",
        crew ?: "",
        edited ?: "",
        hyperdriveRating ?: "",
        length ?: "",
        manufacturer ?: "",
        maxAtmospheringSpeed ?: "",
        model ?: "",
        name ?: "",
        passengers ?: "",
        starshipClass ?: "",
        url ?: "",
        films = if (films.isNullOrEmpty()) emptyList() else films,
        pilots = if (pilots.isNullOrEmpty()) emptyList() else pilots,
    )
}