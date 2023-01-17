package com.paulo.starwars.domain.usecases.favorite

import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.repository.ILocalRepository
import com.paulo.starwars.utils.InvalidFavoriteException

class AddFavoriteUseCase(
    private val repository: ILocalRepository
) {

    suspend operator fun invoke(fav: Favorite){
        if(fav.name.isBlank()){
            throw InvalidFavoriteException("THe name of the favorite can't be empty")
        }else{
            repository.addFavorite(fav)
        }

    }
}


