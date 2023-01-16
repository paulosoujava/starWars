package com.paulo.starwars.domain.usecases.profile

import com.paulo.starwars.domain.usecases.favorite.AddFavoriteUseCase
import com.paulo.starwars.domain.usecases.favorite.DeleteFavoriteUseCase
import com.paulo.starwars.domain.usecases.favorite.GetFavoriteByCodeUseCase

data class UseCases(
     val addFavoriteUseCase: AddFavoriteUseCase,
     val deleteFavoriteUseCase: DeleteFavoriteUseCase,
     val getProfileUseCase: GetProfileUseCase,
     val getFavoriteByCodeUseCase: GetFavoriteByCodeUseCase
)