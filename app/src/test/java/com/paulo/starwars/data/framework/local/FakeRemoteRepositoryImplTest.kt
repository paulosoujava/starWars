package com.paulo.starwars.data.framework.local


import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.repository.ILocalRepository


class FakeRemoteRepositoryImplTest: ILocalRepository {

     private val people = mutableListOf<Favorite>()

    override suspend fun getFavorite(): List<Favorite> {
        return people
    }

    override suspend fun getFavoriteByCode(code: String): Favorite {
        return people[code.toInt()]
    }

    override suspend fun addFavorite(favorite: Favorite) {
        people.add(favorite)
    }

    override suspend fun deleteFavorite(code: String) {
        people.removeIf{ it.id == code.toInt()}
    }


}