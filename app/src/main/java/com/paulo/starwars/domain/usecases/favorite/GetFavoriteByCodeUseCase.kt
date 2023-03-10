package com.paulo.starwars.domain.usecases.favorite

import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.repository.ILocalRepository
import com.paulo.starwars.utils.InvalidFavoriteException

class GetFavoriteByCodeUseCase(
    private val repository: ILocalRepository
) {

    suspend operator fun invoke(code: String) = repository.getFavoriteByCode(code)

}