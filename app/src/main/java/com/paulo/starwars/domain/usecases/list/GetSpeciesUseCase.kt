package com.paulo.starwars.domain.usecases.list


import com.paulo.starwars.domain.models.Species
import com.paulo.starwars.domain.repository.IRemoteRepository


class GetSpeciesUseCase(
    private val repository: IRemoteRepository
) {
    suspend operator fun invoke(): List<Species> {
        return repository.getSpecies()
    }

}
