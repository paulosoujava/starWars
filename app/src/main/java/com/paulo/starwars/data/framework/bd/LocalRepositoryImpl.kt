package com.paulo.starwars.data.framework.bd


import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.repository.ILocalRepository



class LocalRepositoryImpl(
    private val dao: FavoriteDao
) : ILocalRepository {

    override suspend fun getFavorite(): List<Favorite> {
       return dao.getFavorite()
    }

    override suspend fun addFavorite(favorite: Favorite) {
        dao.addFavorite(favorite)
    }

    override suspend fun deleteFavorite(code: String) {
        dao.deleteFavorite(code)
    }

    override suspend fun getFavoriteByCode(code: String): Favorite  {
        return dao.getFavoriteByCode(code)
    }


}