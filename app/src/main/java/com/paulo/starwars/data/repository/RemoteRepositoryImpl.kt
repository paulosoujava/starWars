package com.paulo.starwars.data.repository


import android.util.Log
import com.paulo.starwars.data.Api
import com.paulo.starwars.data.Result
import com.paulo.starwars.domain.models.Films
import com.paulo.starwars.domain.models.Home
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.models.Planets
import com.paulo.starwars.domain.models.Species
import com.paulo.starwars.domain.models.Starships
import com.paulo.starwars.domain.models.Vehicles

import com.paulo.starwars.domain.repository.IRemoteRepository

class RemoteRepositoryImpl(
    private val api: Api
) : IRemoteRepository {


    override suspend fun getPeoples(page: Long): Result<People> {

        val result = api.getPeople(page)
        val list = result.results.map { it.toDomain() }
        val count = result.count
        return Result(count = count, results = list)
    }

    override suspend fun getVehicles(): List<Vehicles> {
        TODO()
    }

    override suspend fun getFilms(): List<Films> {
        TODO()
    }

    override suspend fun getPlants(): List<Planets> {
        TODO()
    }

    override suspend fun getStarships(): List<Starships> {
        TODO()
    }

    override suspend fun getSpecies(): List<Species> {
        TODO()
    }
}