package com.paulo.starwars.domain.usecases.list


import com.paulo.starwars.domain.models.Planets
import com.paulo.starwars.domain.models.Species
import com.paulo.starwars.domain.repository.IRemoteRepository


class GetPlanetsUseCase(
    private val repository: IRemoteRepository
) {
    suspend operator fun invoke(): List<Planets> {
        return repository.getPlants()
    }

}
