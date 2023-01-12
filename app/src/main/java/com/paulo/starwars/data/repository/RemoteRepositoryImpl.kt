package com.paulo.starwars.data.repository

import com.paulo.starwars.data.Api
import com.paulo.starwars.domain.models.Home

import com.paulo.starwars.domain.repository.IRemoteRepository

class RemoteRepositoryImpl(
    private val api: Api
) : IRemoteRepository {

    override suspend fun getHome(): List<Home> {
        return api.getHome().map { it.toDomain() }
    }
}