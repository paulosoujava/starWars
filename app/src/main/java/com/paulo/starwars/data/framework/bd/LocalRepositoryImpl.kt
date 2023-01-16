package com.paulo.starwars.data.framework.bd


import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.repository.ILocalRepository
import kotlinx.coroutines.flow.Flow


class LocalRepositoryImpl(
    private val dao: FavoriteDao
) : ILocalRepository {

    override suspend fun getFavorite(id: String): Flow<Favorite> {
       return dao.getFavorite()
    }

    override suspend fun addFavorite(favorite: Favorite) {
        dao.addFavorite(favorite)
    }

    override suspend fun deleteFavorite(favorite: Favorite) {
        dao.deleteFavorite(favorite)
    }


}