package com.paulo.starwars.domain.repository


import com.paulo.starwars.domain.models.Favorite


interface ILocalRepository {
    suspend fun getFavorite():List<Favorite>
    suspend fun getFavoriteByCode(code: String): Favorite?
    suspend fun addFavorite(favorite: Favorite)
    suspend fun deleteFavorite(code: String)

}