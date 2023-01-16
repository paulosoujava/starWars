package com.paulo.starwars.domain.usecases.favorite

import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.repository.ILocalRepository

class AddFavoriteUseCase(
    private val repository: ILocalRepository
) {

    suspend operator fun invoke(fav: Favorite){
        repository.addFavorite(fav)
    }
}