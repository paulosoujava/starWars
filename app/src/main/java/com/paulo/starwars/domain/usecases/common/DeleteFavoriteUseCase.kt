package com.paulo.starwars.domain.usecases.common

import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.repository.ILocalRepository

class DeleteFavoriteUseCase(
    private val repository: ILocalRepository
) {
    suspend operator fun invoke(code: String) =repository.deleteFavorite(code)
}