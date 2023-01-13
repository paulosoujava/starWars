package com.paulo.starwars.data

import com.paulo.starwars.data.dto.remote.FilmsDto
import com.paulo.starwars.data.dto.remote.PeopleDto
import com.paulo.starwars.data.dto.remote.PlanetsDto
import com.paulo.starwars.data.dto.remote.SpeciesDto
import com.paulo.starwars.data.dto.remote.StarshipsDto
import com.paulo.starwars.data.dto.remote.VehiclesDto
import com.paulo.starwars.domain.models.Films
import com.paulo.starwars.domain.models.Planets
import com.paulo.starwars.domain.models.Species
import com.paulo.starwars.domain.models.Starships
import com.paulo.starwars.domain.models.Vehicles
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {
    @GET("people")
    suspend fun getPeople(
         @Query("page") page: Long
    ): Result<PeopleDto>

    @GET("films")
    suspend fun getFilms(): Result<FilmsDto>

    @GET("planets")
    suspend fun getPlanets(): Result<PlanetsDto>

    @GET("species")
    suspend fun getSpecies(): Result<SpeciesDto>

    @GET("starships")
    suspend fun getStarships(): Result<StarshipsDto>

    @GET("vehicles")
    suspend fun getVehicles(): Result<VehiclesDto>



}
