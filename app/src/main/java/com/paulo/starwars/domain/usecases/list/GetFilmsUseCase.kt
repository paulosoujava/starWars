package com.paulo.starwars.domain.usecases.list


import com.paulo.starwars.domain.models.Films
import com.paulo.starwars.domain.repository.IRemoteRepository


class GetFilmsUseCase(
    private val repository: IRemoteRepository
) {
    suspend operator fun invoke(): List<Films> {
        return repository.getFilms()
    }

}
