package com.paulo.starwars.domain.usecases.profile

import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.repository.ILocalRepository

class GetFavoriteByCodeUseCase(
    private val repository: ILocalRepository
) {

    suspend operator fun invoke(code: String) = repository.getFavoriteByCode(code)

}