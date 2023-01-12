package com.paulo.starwars.domain.repository

import com.paulo.starwars.domain.models.Films
import com.paulo.starwars.domain.models.Home
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.models.Planets
import com.paulo.starwars.domain.models.Species
import com.paulo.starwars.domain.models.Starships
import com.paulo.starwars.domain.models.Vehicles

interface IRemoteRepository {
    suspend fun getHome(): List<Home>
    suspend fun  getPeoples(): List<People>
    suspend fun  getVehicles(): List<Vehicles>
    suspend fun  getFilms(): List<Films>
    suspend fun  getPlants(): List<Planets>
    suspend fun  getStarships(): List<Starships>
    suspend fun  getSpecies(): List<Species>
}