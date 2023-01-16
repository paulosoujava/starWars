package com.paulo.starwars.data.framework.network.dto.remote

import com.google.gson.annotations.SerializedName
import com.paulo.starwars.domain.models.Films
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.models.Vehicles

data class VehiclesDto(
    @SerializedName("cargo_capacity")
    val cargoCapacity: String?,
    val consumables: String?,
    @SerializedName("cost_in_credits")
    val costInCredits: String?,
    @SerializedName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String?,
    @SerializedName("vehicle_class")
    val vehicleClass: String?,

    val created: String?,
    val crew: String?,
    val edited: String?,
    val length: String?,
    val manufacturer: String?,
    val model: String?,
    val name: String?,
    val passengers: String?,
    val url: String?,


    val pilots: List<String>?,
    val films: List<String>?,
) {
    fun toDomain() = Vehicles(
        cargoCapacity?:"",
        consumables?:"",
        costInCredits?:"",
        created?:"",
        crew?:"",
        edited?:"",
        length?:"",
        manufacturer?:"",
        maxAtmospheringSpeed?:"",
        model?:"",
        name?:"",
        passengers?:"",
        url?:"",
        vehicleClass?:"",
        films = if (films.isNullOrEmpty()) emptyList() else films,
        pilots = if (pilots.isNullOrEmpty()) emptyList() else pilots,
    )
}