package com.paulo.starwars.domain.usecases.profile

import com.paulo.starwars.domain.usecases.common.AddFavoriteUseCase
import com.paulo.starwars.domain.usecases.common.DeleteFavoriteUseCase

data class UseCases(
     val addFavoriteUseCase: AddFavoriteUseCase,
     val deleteFavoriteUseCase: DeleteFavoriteUseCase,
     val getProfileUseCase: GetProfileUseCase,
     val getFavoriteByCodeUseCase: GetFavoriteByCodeUseCase
)