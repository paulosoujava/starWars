package com.paulo.starwars.domain.repository

import com.paulo.starwars.domain.models.Home

interface IRemoteRepository {
    suspend fun getHome(): List<Home>
}