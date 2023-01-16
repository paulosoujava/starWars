package com.paulo.starwars.domain.usecases.favorite

data class UseCases(
     val getFavoriteUseCase: GetFavoriteUseCase,
     val deleteFavoriteUseCase: DeleteFavoriteUseCase,
     val addFavoriteUseCase: AddFavoriteUseCase
)