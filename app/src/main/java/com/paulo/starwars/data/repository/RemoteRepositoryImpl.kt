package com.paulo.starwars.data.repository

import com.paulo.starwars.data.Api
import com.paulo.starwars.data.Result
import com.paulo.starwars.data.getImageHome
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

    override suspend fun getHome(): List<Home> {
        return getImageHome().map { it.toDomain() }
    }
    override suspend fun getPeoples(): List<People> {
        val response = api.getPeople()
        return response.results
    }

    override suspend fun getVehicles(): List<Vehicles> {
        val response = api.getVehicles()
        return response.results
    }

    override suspend fun getFilms(): List<Films> {
        val response = api.getFilms()
        return response.results
    }

    override suspend fun getPlants(): List<Planets> {
        val response = api.getPlanets()
        return response.results
    }

    override suspend fun getStarships(): List<Starships> {
        val response = api.getStarships()
        return response.results
    }

    override suspend fun getSpecies(): List<Species> {
        val response = api.getSpecies()
        return response.results
    }
}