package com.paulo.starwars.domain.repository


import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.models.People
import kotlinx.coroutines.flow.Flow


interface ILocalRepository {
    suspend fun getFavorite(id: String):Flow<Favorite>
    suspend fun addFavorite(favorite: Favorite)
    suspend fun deleteFavorite(favorite: Favorite)
}