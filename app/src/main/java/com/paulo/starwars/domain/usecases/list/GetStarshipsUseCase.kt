package com.paulo.starwars.domain.usecases.list


import com.paulo.starwars.domain.models.Species
import com.paulo.starwars.domain.models.Starships
import com.paulo.starwars.domain.repository.IRemoteRepository


class GetStarshipsUseCase(
    private val repository: IRemoteRepository
) {
    suspend operator fun invoke(): List<Starships> {
        return repository.getStarships()
    }

}
