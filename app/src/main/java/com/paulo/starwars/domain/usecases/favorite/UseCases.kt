package com.paulo.starwars.domain.usecases.favorite

import com.paulo.starwars.domain.usecases.common.AddFavoriteUseCase
import com.paulo.starwars.domain.usecases.common.DeleteFavoriteUseCase

data class UseCases(
     val getFavoriteUseCase: GetFavoriteUseCase,
     val deleteFavoriteUseCase: DeleteFavoriteUseCase,
     val addFavoriteUseCase: AddFavoriteUseCase
)