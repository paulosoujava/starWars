package com.paulo.starwars.data.framework.network

import com.paulo.starwars.data.framework.network.dto.remote.FilmsDto
import com.paulo.starwars.data.framework.network.dto.remote.PeopleDto
import com.paulo.starwars.data.framework.network.dto.remote.PlanetsDto
import com.paulo.starwars.data.framework.network.dto.remote.SpeciesDto
import com.paulo.starwars.data.framework.network.dto.remote.StarshipsDto
import com.paulo.starwars.data.framework.network.dto.remote.VehiclesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Api {
    @GET("people")
    suspend fun getPeople(@Query("page") page: Long): Result<PeopleDto>

    @GET("people/{id}")
    suspend fun getProfileById(@Path("id") id: Long): PeopleDto

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
