package com.paulo.starwars.domain.usecases.list

data class GetListUseCases(
    val getHomeUSeCase: GetHomeUseCase,
    val getFilmsUseCase: GetFilmsUseCase,
    val getPeopleUseCase: GetPeopleUseCase,
    val getPlanetsUseCase: GetPlanetsUseCase,
    val getVehiclesUseCase: GetVehiclesUseCase,
    val getSpeciesUseCase: GetSpeciesUseCase,
    val getStarshipsUseCase: GetStarshipsUseCase
)
